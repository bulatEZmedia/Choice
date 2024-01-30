package com.example.mychoiceai;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentEmail extends Fragment {

   EditText editTextEmail;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_email, container, false);
        editTextEmail = view.findViewById(R.id.editTextEmail);
        Button then3 = view.findViewById(R.id.then3);
        editTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                then3.setBackgroundColor(getResources().getColor(R.color.beforeTextForButton));
                then3.setTextColor(getResources().getColor(R.color.beforeTextForText));
            }

            @Override
            public void afterTextChanged(Editable editable) {
                then3.setBackgroundColor(getResources().getColor(R.color.beforeTextForButton));
                then3.setTextColor(getResources().getColor(R.color.beforeTextForText));
            }
        });

        then3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString().trim();

                retrofit2.Call<ResponseBody> call = RetrofitClient
                        .getInstance()
                        .getApi()
                        .email_checking(email);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            String userId = response.body().string();
                            int num = Integer.parseInt(userId);
                            if(num == 0){
                                Navigation.findNavController(view).navigate(R.id.action_fragmentEmail_to_fragmentPasswordRegister);
                            }
                            else {
                                Bundle bundle = new Bundle();
                                bundle.putString("user_id", userId);
                                Navigation.findNavController(view).navigate(R.id.action_fragmentEmail_to_fragmentPasswordAuthorization, bundle);

                            }
                        }
                        catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });

            }
        });
        return view;
    }
}