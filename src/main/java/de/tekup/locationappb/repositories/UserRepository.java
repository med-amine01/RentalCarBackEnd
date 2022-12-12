package de.tekup.locationappb.repositories;

import de.tekup.locationappb.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {

}
