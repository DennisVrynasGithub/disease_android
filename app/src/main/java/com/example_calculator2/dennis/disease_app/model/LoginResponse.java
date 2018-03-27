package com.example_calculator2.dennis.disease_app.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    private boolean success;
    private String message;

    @SerializedName("user_email")
    private String user_email;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}
