package de.tekup.locationappb.repositories;

import de.tekup.locationappb.entites.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;
@CrossOrigin("http://localhost:4200")
public interface ClientRepository extends JpaRepository<Client,Integer> {

}
