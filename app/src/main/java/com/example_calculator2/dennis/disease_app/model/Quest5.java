package com.example_calculator2.dennis.disease_app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//Created by Dennis on 10/1/2018.


public class Quest5 {

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("age")
    @Expose
    private String age;

    @SerializedName("illnes")
    @Expose
    private String illnes;

    @SerializedName("medical")
    @Expose
    private String medical;

    @SerializedName("side_effect")
    @Expose
    private String side_effect;

    @SerializedName("new_medical")
    @Expose
    private String new_medical;

    @SerializedName("id_2")
    @Expose
    private String id_2;

    public Quest5(String gender, String age, String illnes, String medical, String side_effect, String new_medical, String id_2) {
        this.gender = gender;
        this.age = age;
        this.illnes = illnes;
        this.medical = medical;
        this.side_effect = side_effect;
        this.new_medical = new_medical;
        this.id_2 = id_2;
    }

    public Quest5() {

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIllnes() {
        return illnes;
    }

    public void setIllnes(String illnes) {
        this.illnes = illnes;
    }

    public String getMedical() {
        return medical;
    }

    public void setMedical(String medical) {
        this.medical = medical;
    }

    public String getSide_effect() {
        return side_effect;
    }

    public void setSide_effect(String side_effect) {
        this.side_effect = side_effect;
    }

    public String getNew_medical() {
        return new_medical;
    }

    public void setNew_medical(String new_medical) {
        this.new_medical = new_medical;
    }

    public String getId_2() {
        return id_2;
    }

    public void setId_2(String id_2) {
        this.id_2 = id_2;
    }
}
