package com.example.mychoiceai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;


public class FragmentPasswordRegister extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_password_register, container, false);
        EditText editTextPassword1 = view.findViewById(R.id.editTextPassword1);
        EditText editTextPassword2 = view.findViewById(R.id.editTextPassword2);
        Button then6 = view.findViewById(R.id.then6);

        TextInputLayout passwordLayout1 = view.findViewById(R.id.layoutTextPassword1);
        TextInputLayout passwordLayout2 = view.findViewById(R.id.layoutTextPassword2);


        /*editTextPassword1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                passwordLayout1.setHelperText(validPassword());
            }

            private CharSequence validPassword() {
                if(password1.length() < 8){
                    return "wef";
                }
                return null;
            }
        });*/

        then6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password1 = editTextPassword1.getText().toString().trim();
                String password2 = editTextPassword2.getText().toString().trim();
                if (password1.length() <= 8 ){
                    editTextPassword1.setError("Введите 8 символов");
                }
                //if(!password1.equals(password2)){
                  //  editTextPassword2.setError("Пароли не совпадают");
                //}
                else{
                    Bundle bundle = getArguments();
                    bundle.putString("password", password1);
                    Navigation.findNavController(view).navigate(R.id.action_fragmentPasswordRegister_to_fragmentName, bundle);
                }

            }
        });

        return view;
    }

}