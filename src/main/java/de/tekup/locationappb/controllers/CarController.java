package de.tekup.locationappb.controllers;


import de.tekup.locationappb.entites.Car;
import de.tekup.locationappb.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class CarController {

    private CarService carService;

    @PatchMapping("/updatecar")
    public Car updateCar(@RequestBody Car car){
        return carService.updateCar(car);
    }

    @PostMapping("/addcar")
    public Car addNewCar(@RequestBody Car car){
        return  carService.addCar(car);
    }

    @GetMapping("/allcars")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @GetMapping("/id")
    public Car getCarById(@RequestParam("id") int carId){
        return carService.getCarById(carId);
    }

    public List<Car> getCarByModel(@RequestParam("brand") String brand){
        return carService.getCarByBrand(brand);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public String handleIllegalArgumentException(IllegalArgumentException e ){
        return e.getMessage();
    }
}
