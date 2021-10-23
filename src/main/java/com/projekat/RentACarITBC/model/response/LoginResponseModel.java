package com.projekat.RentACarITBC.model.response;

public class LoginResponseModel {
    private boolean successuful;
    private  String info;

    public LoginResponseModel(boolean successuful, String userId) {
        this.successuful = successuful;
        this.info = userId;
    }

    public boolean isSuccessuful() {
        return successuful;
    }

    public String getInfo() {
        return info;
    }
}
