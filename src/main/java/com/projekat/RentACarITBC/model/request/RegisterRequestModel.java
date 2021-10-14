package com.projekat.RentACarITBC.model.request;

public class RegisterRequestModel {
    private String username, password, email;

    public RegisterRequestModel(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
