package com.example_calculator2.dennis.disease_app.model;

/**
 * Created by Dennis on 30/3/2018.
 */

public class DeleteHistoryResponse {


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
