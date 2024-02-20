package com.example.mychoiceai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class FragmentLogin extends Fragment {

    EditText editTextLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        Button then1 = view.findViewById(R.id.then1);

        editTextLogin = view.findViewById(R.id.email);
        then1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = editTextLogin.getText().toString().trim();
                Bundle bundle = getArguments();
                bundle.putString("login", login);
                //Navigation.findNavController(view).navigate(R.id.action_fragmentLogin_to_fragmentName, bundle);
            }
        });


        // Toast.makeText(getActivity(), getArguments().getString("gender"), Toast.LENGTH_SHORT).show();

        return view;
    }
}