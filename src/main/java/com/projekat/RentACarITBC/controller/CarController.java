package com.projekat.RentACarITBC.controller;
import com.projekat.RentACarITBC.dao.CarDao;
import com.projekat.RentACarITBC.dao.CarDaoSQL;
import com.projekat.RentACarITBC.model.CarModel;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
public class CarController {
    private static final CarDao cardao = new CarDaoSQL();

    @GetMapping("/cars")
    public List<CarModel> getAllCars (){
        return cardao.getAllCars();
    }

    @GetMapping("/cars/search")
    public List<CarModel> carListByParams (@RequestParam int year, @RequestParam String make, @RequestParam String model, @RequestParam boolean automatic, @RequestParam double price, @RequestParam int power, @RequestParam int doors){
        return cardao.search(year, make, model, automatic, price, power, doors);
    }

    @GetMapping("/cars/{carId}")
    public CarModel car (@PathVariable("carId") String carId){
        return cardao.getCar(carId);
    }

    @PatchMapping("/cars/{carId}")
    public void changeCar (@RequestHeader("userId") String userId, @PathVariable("carId") String carId, @RequestBody CarModel car ){
        if (cardao.isAdmin(userId)) {
            car.setCarId(UUID.fromString(carId));
            cardao.changeCar(car);
        }
    }

    @DeleteMapping("/cars/{carId}")
    public void deleteCar (@RequestHeader("userId") String userId, @PathVariable("carId") String carId){
        if (cardao.isAdmin(userId))
            cardao.delete(carId);
    }

    @PostMapping("/cars")
    public void addCar (@RequestHeader("userId") String userId, @RequestBody CarModel car){
        if (cardao.isAdmin(userId)) {
            car.setCarId(UUID.randomUUID());
            cardao.add(car);
        }
    }




}
