package com.projekat.RentACarITBC.dao;

import com.projekat.RentACarITBC.model.CarModel;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface CarDao {
    List<CarModel> getAllCars();
    List<CarModel> search(int year, String make, String model, boolean automatic, double price, int power, int doors);
    CarModel getCar(String carID);
    void changeCar(CarModel car);
    boolean isAdmin(String userId);
    void delete(String carId);
    void add(CarModel car);
    List<CarModel> availableCar(Date start, Date end);

}
