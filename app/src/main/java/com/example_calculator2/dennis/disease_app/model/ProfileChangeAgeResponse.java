package com.example_calculator2.dennis.disease_app.model;

import java.lang.reflect.Array;

/**
 * Created by Dennis on 28/3/2018.
 */

public class ProfileChangeAgeResponse {
    private boolean success;
    private String message;



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
}
