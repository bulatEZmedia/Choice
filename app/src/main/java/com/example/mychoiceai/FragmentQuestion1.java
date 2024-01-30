package com.example.mychoiceai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentQuestion1 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question1, container, false);
        Button button1 = view.findViewById(R.id.button3);
        Button button2 = view.findViewById(R.id.button2);
        Button button3 = view.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = "Похудеть";
                int userId = Integer.parseInt(getArguments().getString("user_id"));

                retrofit2.Call<ResponseBody> call = RetrofitClient
                        .getInstance()
                        .getApi()
                        .additional_information(userId, answer);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            Log.d("TAG", "onResponse: " + response.body().string());

                        }
                        catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
                Navigation.findNavController(view).navigate(R.id.action_fragmentQuestion1_to_fragmentRegisterDone);
            }

        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = "Нарастить мышцы";
                int userId = Integer.parseInt(getArguments().getString("user_id"));
                retrofit2.Call<ResponseBody> call = RetrofitClient
                        .getInstance()
                        .getApi()
                        .additional_information(userId, answer);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            Log.d("TAG", "onResponse: " + response.body().string());

                        }
                        catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
                Navigation.findNavController(view).navigate(R.id.action_fragmentQuestion1_to_fragmentRegisterDone);
            }

        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = "Быть в форме";
                int userId = Integer.parseInt(getArguments().getString("user_id"));
                retrofit2.Call<ResponseBody> call = RetrofitClient
                        .getInstance()
                        .getApi()
                        .additional_information(userId, answer);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            Log.d("TAG", "onResponse: " + response.body().string());

                        }
                        catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
                Navigation.findNavController(view).navigate(R.id.action_fragmentQuestion1_to_fragmentRegisterDone);
            }
        });

        return view;
    }
}