package de.tekup.locationappb.repositories;

import de.tekup.locationappb.entites.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,String> {

}
