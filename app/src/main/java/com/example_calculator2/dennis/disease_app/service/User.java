package com.example_calculator2.dennis.disease_app.service;

import com.example_calculator2.dennis.disease_app.model.Quest1;
import com.example_calculator2.dennis.disease_app.model.Quest2;
import com.example_calculator2.dennis.disease_app.model.Quest3;
import com.example_calculator2.dennis.disease_app.model.Quest4;
import com.example_calculator2.dennis.disease_app.model.Quest5;
import com.example_calculator2.dennis.disease_app.model.Quest6;
import com.example_calculator2.dennis.disease_app.model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


//Created by Dennis on 3/1/2018.

public interface User {

    @FormUrlEncoded
    @POST("post_register.php")
    Call<Users> insertUserRegister(@Field("user_name") String user_name,
                                   @Field("user_password") String user_password,
                                   @Field("user_email") String user_email,
                                   @Field("user_country") String user_country,
                                   @Field("user_age") String user_age,
                                   @Field("user_gendre") String user_gendre);

    @FormUrlEncoded
    @POST("update_user_name.php")
    Call<Users> updatename(@Field("user_name") String user_name,
                           @Field("user_email") String user_email);

    @FormUrlEncoded
    @POST("update_user_password.php")
    Call<Users> updatepassword(@Field("user_password") String user_password,
                           @Field("user_email") String user_email);

    @FormUrlEncoded
    @POST("update_user_country.php")
    Call<Users> updatecountry(@Field("user_country") String user_country,
                           @Field("user_email") String user_email);

    @FormUrlEncoded
    @POST("update_user_age.php")
    Call<Users> updateage(@Field("user_age") String user_age,
                           @Field("user_email") String user_email);


    @FormUrlEncoded
    @POST("questionnaire1.php")
    Call<Quest1> insertQuset1(@Field("gender") String gender,
                              @Field("age") String age,
                              @Field("medication") String medication,
                              @Field("illnes") String illnes,
                              @Field("procedure_1") String procedure_1,
                              @Field("id_2") String id_2);


    @FormUrlEncoded
    @POST("questionnaire2.php")
    Call<Quest2> insertQuset2(@Field("gender") String gender,
                              @Field("age") String age,
                              @Field("illnes_history") String illnes_history,
                              @Field("succeed_time") String succeed_time,
                              @Field("medical_history") String medical_history,
                              @Field("id_2") String id_2);


    @FormUrlEncoded
    @POST("questionnaire3.php")
    Call<Quest3> insertQuset3(@Field("gender") String gender,
                              @Field("age") String age,
                              @Field("chronic_problem") String chronic_problem,
                              @Field("years") String years,
                              @Field("medical") String medical,
                              @Field("other_illnes") String other_illnes,
                              @Field("id_2") String id_2);


    @FormUrlEncoded
    @POST("questionnaire4.php")
    Call<Quest4> insertQuset4(@Field("gender") String gender,
                              @Field("age") String age,
                              @Field("illnes") String illnes,
                              @Field("caused_other") String caused_other,
                              @Field("treatment") String treatment,
                              @Field("time") String time,
                              @Field("id_2") String id_2);


    @FormUrlEncoded
    @POST("questionnaire5.php")
    Call<Quest5> insertQuset5(@Field("gender") String gender,
                              @Field("age") String age,
                              @Field("illnes") String illnes,
                              @Field("medical") String medical,
                              @Field("side_effect") String side_effect,
                              @Field("new_medical") String new_medical,
                              @Field("id_2") String id_2);


    @FormUrlEncoded
    @POST("questionnaire6.php")
    Call<Quest6> insertQuset6(@Field("gender") String gender,
                              @Field("age") String age,
                              @Field("heredity_history") String heredity_history,
                              @Field("illnes_heredity") String illnes_heredity,
                              @Field("treatment") String treatment,
                              @Field("id_2") String id_2);



}
