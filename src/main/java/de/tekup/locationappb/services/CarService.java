package de.tekup.locationappb.services;


import de.tekup.locationappb.entites.Car;
import de.tekup.locationappb.repositories.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class CarService {
    private CarRepository carRepository;

    public Car addCar(Car car){
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
    public Car getCarById(int id){
        return carRepository
                .findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Car ID not Found"));
    }

    public List<Car> getCarByModel(String model){
        return carRepository.findByModelContaining(model);
    }



    //@PostConstruct
//    private void addVoituresToEmptyDB(){
//        if(carRepository.count()==0){
//            insertIntoDB(new Car("00Tunis0001",
//                    LocalDate.of(2022,01,03),"GOLF 7"));
//            insertIntoDB(new Car("00Tunis0002",
//                    LocalDate.of(2022,01,04),"POLO 8"));
//        }
//
//    }

}
