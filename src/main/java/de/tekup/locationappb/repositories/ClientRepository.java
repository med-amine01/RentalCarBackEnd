package de.tekup.locationappb.repositories;

import de.tekup.locationappb.entites.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("http://localhost:4200")
public interface ClientRepository extends JpaRepository<Client,Integer> {

    Client findClientByEmail(String email);
}
