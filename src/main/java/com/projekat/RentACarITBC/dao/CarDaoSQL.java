package com.projekat.RentACarITBC.dao;

import com.projekat.RentACarITBC.db.DatabaseConnection;
import com.projekat.RentACarITBC.model.CarModel;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class CarDaoSQL implements CarDao{
    private static final Connection conn = DatabaseConnection.getConnection();

    @Override
    public List<CarModel> getAllCars() {
        List<CarModel> allCar = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cars");
            while (rs.next()){
                allCar.add(new CarModel(
                        UUID.fromString(rs.getString(1)),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getDouble(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getBoolean(12),
                        rs.getString(13),
                        rs.getString(14)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCar;
    }

    @Override
    public List<CarModel> search(int year, String make, String model, boolean automatic, double price, int power, int doors) {
        List<CarModel> cars = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cars WHERE year = " + year +
                    " OR make = '" + make +
                    "' OR model = '" + model +
                    "' OR automatic = " + automatic +
                    " OR price = " + price +
                    " OR power = " + power +
                    " OR doors = " + doors);

            while (rs.next()){
                cars.add(new CarModel(
                        UUID.fromString(rs.getString(1)),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getDouble(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getBoolean(12),
                        rs.getString(13),
                        rs.getString(14)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public CarModel getCar(String carID) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cars WHERE car_id = '" + carID + "'");
            if (rs.next()) {
                return new CarModel(
                        UUID.fromString(rs.getString(1)),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getDouble(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getBoolean(12),
                        rs.getString(13),
                        rs.getString(14));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void changeCar(CarModel car) {
        try{
            PreparedStatement st = conn.prepareStatement("UPDATE cars SET " +
                    "licence_plate = ?, " +
                    "make = ?, " +
                    "model = ?, " +
                    "year = ?, " +
                    "engine_capacity = ?, " +
                    "color = ?, " +
                    "price = ?, " +
                    "doors = ?, " +
                    "size = ?, " +
                    "power = ?, " +
                    "automatic = ?, " +
                    "fuel = ?, " +
                    "image = ? " +
                    "WHERE car_id = ?");
            st.setString(1, car.getLicencePlate());
            st.setString(2, car.getMake());
            st.setString(3, car.getModel());
            st.setInt(4, car.getYear());
            st.setInt(5, car.getEngineCapacity());
            st.setString(6, car.getColor());
            st.setDouble(7, car.getPrice());
            st.setInt(8, car.getDoors());
            st.setString(9, car.getSize());
            st.setInt(10, car.getPower());
            st.setBoolean(11, car.isAutomatic());
            st.setString(12, car.getFuel());
            st.setString(13, car.getImage());
            st.setString(14, car.getCarId().toString());
            st.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean isAdmin(String userId){
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT admin FROM users WHERE user_id = '" + userId + "'");
            if (rs.next())
                return rs.getBoolean(1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(String carId) {
        try{
            PreparedStatement st = conn.prepareStatement("DELETE FROM cars WHERE car_id = ?");
            st.setString(1, carId);
            st.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void add(CarModel car) {
        try{
            PreparedStatement st = conn.prepareStatement("INSERT INTO cars VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, car.getCarId().toString());
            st.setString(2, car.getLicencePlate());
            st.setString(3, car.getMake());
            st.setString(4, car.getModel());
            st.setInt(5, car.getYear());
            st.setInt(6, car.getEngineCapacity());
            st.setString(7, car.getColor());
            st.setDouble(8, car.getPrice());
            st.setInt(9, car.getDoors());
            st.setString(10, car.getSize());
            st.setInt(11, car.getPower());
            st.setBoolean(12, car.isAutomatic());
            st.setString(13, car.getFuel());
            st.setString(14, car.getImage());
            st.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<CarModel> availableCar(Date start, Date end) {
        return null;
    }
}
