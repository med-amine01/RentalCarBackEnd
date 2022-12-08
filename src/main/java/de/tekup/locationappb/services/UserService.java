package de.tekup.locationappb.services;

import de.tekup.locationappb.entites.Role;
import de.tekup.locationappb.entites.User;
import de.tekup.locationappb.repositories.RoleRepository;
import de.tekup.locationappb.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public User userRegister(User user){
        return userRepository.save(user);

    }
    public void initRolesAndUsers(){
        Role adminRole=new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin Role");
        roleRepository.save(adminRole);

        Role userRole=new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("User Role");
        roleRepository.save(userRole);

        User adminUser=new User();
        adminUser.setUsername("Admin");
        adminUser.setUserFirstName("Admin");
        adminUser.setUserLastName("Admin");
        adminUser.setUserPassword("admin@123");
        adminUser.getRole().add(adminRole);
        userRepository.save(adminUser);
        User user=new User();
        user.setUsername("user");
        user.setUserFirstName("user");
        user.setUserLastName("user");
        user.setUserPassword("user@123");
        user.getRole().add(userRole);
        userRepository.save(user);
    }
}
