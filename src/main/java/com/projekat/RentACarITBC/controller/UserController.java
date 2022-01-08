package com.projekat.RentACarITBC.controller;

import com.projekat.RentACarITBC.dao.UserDaoSQL;
import com.projekat.RentACarITBC.model.request.LoginRequestModel;
import com.projekat.RentACarITBC.model.request.RegisterRequestModel;
import com.projekat.RentACarITBC.model.response.LoginResponseModel;
import com.projekat.RentACarITBC.model.response.RegisterResponseModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;

@RestController
public class UserController {
    public static final UserDaoSQL userSql = new UserDaoSQL();

    @PostMapping("/users/register")
    public RegisterResponseModel register (@RequestBody RegisterRequestModel user){
        if (!userSql.isUniqueUser(user.getUsername())){
            return new RegisterResponseModel(false, "Username already in use");
        } else if (!userSql.isUniqueEmail(user.getEmail())){
            return new RegisterResponseModel(false, "Email already in Use");
        } else if (user.getUsername().length() < 3){
            return new RegisterResponseModel(false, "Entry is not valid");
        } else if (!Pattern.matches("^(.+)@(.+)$", user.getEmail())){
            return new RegisterResponseModel(false, "Email is not valid");
        } else if (!Pattern.matches("^(?=.*\\d)(?=.*[a-zA-Z]).{8,20}$", user.getPassword())){
            return new RegisterResponseModel(false, "Password not valid");
        }
        else {
            userSql.register(user);
            return new RegisterResponseModel(true, user.getUsername() + " - " + user.getEmail() + " successufuly registered");
        }
    }

    @PostMapping("users/login")
    public LoginResponseModel login (@RequestBody LoginRequestModel user){
        if (userSql.login(user.getIdentification(), user.getPassword()))
            return new LoginResponseModel(true, userSql.userId(user.getIdentification()));
        else
            return new LoginResponseModel(false, "Wrong username/email or password");
    }

}
