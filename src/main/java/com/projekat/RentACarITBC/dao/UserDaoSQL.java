package com.projekat.RentACarITBC.dao;

import com.projekat.RentACarITBC.db.DatabaseConnection;
import com.projekat.RentACarITBC.model.UserModel;
import com.projekat.RentACarITBC.model.request.RegisterRequestModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDaoSQL implements UserDao{
    private static final Connection conn = DatabaseConnection.getConnection();

    @Override
    public void register(RegisterRequestModel user) {
        try{
            PreparedStatement st = conn.prepareStatement("INSERT INTO users (user_id, username, email, password, admin) VALUES(?,?,?,?,?)");
            st.setString(1, UUID.randomUUID().toString());
            st.setString(2, user.getUsername());
            st.setString(3, user.getEmail());
            st.setString(4, user.getPassword());
            st.setBoolean(5, false);
            st.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean login(String entry, String password) {
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT password FROM users WHERE username = '" + entry + "' OR email = '" + entry + "'");
            return rs.next() && rs.getString(1).equals(password);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean isUniqueUser(String userName){
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT username FROM users WHERE username = '" + userName + "'");

            if (rs.next() && rs.getString(1).equals(userName))
            return false;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public boolean isUniqueEmail(String email){
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT email FROM users WHERE email = '" + email + "'");

            if (rs.next() && rs.getString(1).equals(email))
                return false;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public String userId(String entry){
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT user_id FROM users WHERE username = '" + entry + "' OR email = '" + entry + "'");
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public void update() {

    }

    @Override
    public UserModel getUser(String userId) {
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users WHERE user_id = " + userId);
            if (rs.next()){
                return new UserModel(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getBoolean(9)
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UserModel> getAllUsers() {
        List<UserModel> users = new ArrayList<>();

        return null;
    }
}
