package de.tekup.locationappb.repositories;


import de.tekup.locationappb.entites.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
public interface CarRepository extends JpaRepository<Car,Integer> {

    List<Car> findByModelContaining(String model);
}
