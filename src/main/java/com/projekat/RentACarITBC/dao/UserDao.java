package com.projekat.RentACarITBC.dao;

import com.projekat.RentACarITBC.model.UserModel;
import com.projekat.RentACarITBC.model.request.RegisterRequestModel;

import java.util.List;

public interface UserDao {
    void register(RegisterRequestModel userId);
    boolean login(String entry, String password);
    void update();
    UserModel getUser(String userId);
    List<UserModel> getAllUsers();

}
