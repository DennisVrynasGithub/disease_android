package com.example_calculator2.dennis.disease_app.model;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;

import java.lang.reflect.Array;


public class GetDiseaseResponse{


    @SerializedName("id")
    private String user_email;
    @SerializedName("a2z")
    private String a2z;
    @SerializedName("name")
    private String name;
    @SerializedName("factid")
    private String factid;
    @SerializedName("fact")
    private String fact;
    @SerializedName("description")
    private String description;
}
