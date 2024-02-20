package com.example.mychoiceai;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    @POST("register")
    Call<ResponseBody> register(
            @Query("email") String email,
            @Query("password") String password,
            @Query("name") String name,
            @Query("gender") String gender,
            @Query("birthday") String birthday



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

    @POST("additional_information")
    Call<ResponseBody> additional_information(
            @Query("email") String email,
            @Query("height") String height,
            @Query("currentWeight") String currentWeight,
            @Query("desiredWeight") String desiredWeight,
            @Query("physicalLimitations") String physicalLimitations,
            @Query("body") String body,
            @Query("bodyPart") String bodyPart,
            @Query("mostOfTheDay") String mostOfTheDay,
            @Query("foodOfTheDay") String foodOfTheDay,
            @Query("badHabits") String badHabits,
            @Query("physActivity") String physActivity,
            @Query("mainEvent") String mainEvent,
            @Query("dateEvent") String dateEvent,
            @Query("yourGoal") String yourGoal

    );
}
