package com.projekat.RentACarITBC.model.response;

public class RegisterResponseModel {
    private boolean successuful;
    private String message;

    public RegisterResponseModel(boolean successuful, String message) {
        this.successuful = successuful;
        this.message = message;
    }

    public boolean isSuccessuful() {
        return successuful;
    }

    public String getMessage() {
        return message;
    }
}
