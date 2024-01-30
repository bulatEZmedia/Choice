package com.example.mychoiceai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentPasswordAuthorization extends Fragment {
    EditText editTextPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_password_authorization, container, false);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        Button then4 = view.findViewById(R.id.then4);
        then4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = editTextPassword.getText().toString().trim();

                /*String gender = getArguments().getString("gender");
                String birthday = getArguments().getString("birthday");
                String login = getArguments().getString("login");
                String name = getArguments().getString("name");*/
                String userId1 = getArguments().getString("user_id");
                int userInt = Integer.parseInt(userId1);

                retrofit2.Call<ResponseBody> call = RetrofitClient
                        .getInstance()
                        .getApi()
                        .password_checking(password, userInt);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            String userId2 = response.body().string();
                            int num = Integer.parseInt(userId2);
                            if (num != 0) {
                                Navigation.findNavController(view).navigate(R.id.action_fragmentPasswordAuthorization_to_fragmentBeforeTest);
                            }
                            else{
                                Toast.makeText(getActivity(), "the password is incorrect", Toast.LENGTH_SHORT).show();
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