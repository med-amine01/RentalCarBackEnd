package de.tekup.locationappb.controllers;


import de.tekup.locationappb.entites.Car;
import de.tekup.locationappb.services.CarService;
import de.tekup.locationappb.services.EmailSenderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class CarController {
    private EmailSenderService emailSenderService;
    private CarService carService;

    @DeleteMapping("/deletecar/{id}")
    public boolean deleteCar(@PathVariable int id){
        Car car = carService.getCarById(id);
        if(car != null){
            carService.deleteCar(car.getId());
            return true;
        }
        return false;
    }

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

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable("id") int id){
        try {
            emailSenderService.sendmail("camine500@gmail.com");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return carService.getCarById(id);
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
