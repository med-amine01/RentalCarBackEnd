package de.tekup.locationappb.repositories;

import de.tekup.locationappb.entites.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
