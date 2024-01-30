package com.example.mychoiceai;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    @POST("register")
    Call<ResponseBody> register(
            @Query("gender") String gender,
            @Query("birthday") String birthday,
            @Query("login") String login,
            @Query("name") String name,
            @Query("email") String email,
            @Query("password") String password
    );

    @POST("additional_information")
    Call<ResponseBody> additional_information(
            @Query("user_id") int userId,
            @Query("main_goal") String mainGoal
    );

    @POST("email_checking")
    Call<ResponseBody> email_checking(
            @Query("email") String email
    );

    @POST("password_checking")
    Call<ResponseBody> password_checking(
          @Query("password") String password,
          @Query("user_id") int userId
    );
}
