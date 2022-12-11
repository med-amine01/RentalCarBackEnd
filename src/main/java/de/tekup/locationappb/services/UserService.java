package de.tekup.locationappb.services;

import de.tekup.locationappb.entites.Role;
import de.tekup.locationappb.entites.User;
import de.tekup.locationappb.repositories.RoleRepository;
import de.tekup.locationappb.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import de.tekup.locationappb.config.WebSecurityConfiguration;

import java.util.Set;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

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
        adminUser.setUsername("Admin1");
        adminUser.setUserFirstName("Admin");
        adminUser.setUserLastName("Admin");
        adminUser.setUserPassword(getEncodedPassword("admin@123"));
        adminUser.getRole().add(adminRole);
        userRepository.save(adminUser);
        User user=new User();
        user.setUsername("user1");
        user.setUserFirstName("user");
        user.setUserLastName("user");
        user.setUserPassword(getEncodedPassword("user@123"));
        user.getRole().add(userRole);
        userRepository.save(user);
    }

    public User registerNewUser(User user) {
        Role role = roleRepository.findById("User").get();

        user.getRole().add(role);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        return userRepository.save(user);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
