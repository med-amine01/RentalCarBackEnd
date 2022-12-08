package de.tekup.locationappb.controllers;

import de.tekup.locationappb.entites.Role;
import de.tekup.locationappb.entites.User;
import de.tekup.locationappb.repositories.RoleRepository;
import de.tekup.locationappb.repositories.UserRepository;
import de.tekup.locationappb.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
@AllArgsConstructor
@Controller
public class UserController {
    private UserService userService;
    @PostConstruct
    public void init(){
        userService.initRolesAndUsers();
    }

    @PostMapping("/registerNewUser")
    @ResponseBody
    public User registerNewUser(@RequestBody User user){
        return userService.userRegister(user);
    }
    @GetMapping("/foradmin")
@ResponseBody
    public String forAdmin(){
        System.out.println("wselet");
        return "this is for admin";
    }
    @GetMapping("/foruser")
@ResponseBody
    public String forUser(){
        return "this is for user";
    }

}
