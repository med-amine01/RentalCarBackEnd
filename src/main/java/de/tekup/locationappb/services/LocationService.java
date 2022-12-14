package de.tekup.locationappb.services;

import de.tekup.locationappb.entites.Car;
import de.tekup.locationappb.entites.Location;
import de.tekup.locationappb.entites.User;
import de.tekup.locationappb.repositories.CarRepository;
import de.tekup.locationappb.repositories.LocationRepository;
import de.tekup.locationappb.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@AllArgsConstructor
public class LocationService {

    private LocationRepository locationRepository;
    private UserRepository userRepository;
    private CarRepository carRepository;

    public Location addLocation(Location location){
        User user = userRepository.findById(location.getUser().getUsername()).get();

        Car car1 = carRepository.findById(location.getCar().getId()).get();

        location.setUser(user);
        location.setCar(car1);
        //calculate price
        location.setPrice(calculatePrice(location.getStartDate(), location.getEndDate(), location.getCar()));
        return locationRepository.save(location);
    }

    //calculate price
    private double calculatePrice(LocalDate startDate, LocalDate endDate, Car car){
        long nbDays = ChronoUnit.DAYS.between(startDate,endDate)+1;
        return  car.getDayPrice() * nbDays;
    }

    public List<Location> getAllLocations(){
        return locationRepository.findAll();
    }
}
