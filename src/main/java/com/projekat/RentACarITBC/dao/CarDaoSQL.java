package com.projekat.RentACarITBC.dao;

import com.projekat.RentACarITBC.db.DatabaseConnection;
import com.projekat.RentACarITBC.model.CarModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

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
    public CarModel getCar(UUID carID) {
        return null;
    }

    @Override
    public void delete(UUID carId) {

    }

    @Override
    public void add(CarModel car) {

    }

    @Override
    public List<CarModel> availableCar(Date start, Date end) {
        return null;
    }
}
