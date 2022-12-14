package de.tekup.locationappb.controllers;


import de.tekup.locationappb.config.FileUploadUtil;
import de.tekup.locationappb.entites.Car;
import de.tekup.locationappb.services.CarService;
import de.tekup.locationappb.services.EmailSenderService;
import lombok.AllArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public int addNewCar(@RequestBody Car car){

        return carService.addCar(car).getId();
    }
    @PostMapping("/addcar/img/{id}")
    public Car addImageToCar(@PathVariable("id") int id,
            @RequestParam("file") MultipartFile multipartFile){
        Car car = carService.getCarById(id);
        System.err.println(multipartFile.getSize());
        if(!multipartFile.isEmpty()){
            String orgFileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            String ext = orgFileName.substring(orgFileName.lastIndexOf("."));
            String uploadDir = "C:/Users/camin/Desktop/Angular/rentCarProject/src/assets/images/cars/";
          String fileName = "voiture-"+car.getId()+ext;
            FileUploadUtil.saveFile(uploadDir,fileName,multipartFile);
            car.setImageUrl("/"+uploadDir+fileName);

        }
        return  carService.addCar(car);
    }

    @GetMapping("/allcars")
    public List<Car> getAllCars(){

        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable("id") int id){
//        try {
//            emailSenderService.sendmail("camine500@gmail.com");
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }
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
