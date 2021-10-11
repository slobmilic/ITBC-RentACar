package com.projekat.RentACarITBC.controller;
import com.projekat.RentACarITBC.dao.CarDao;
import com.projekat.RentACarITBC.dao.CarDaoSQL;
import com.projekat.RentACarITBC.model.CarModel;
import org.springframework.web.bind.annotation.*;


import java.util.List;


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

}
