package de.tekup.locationappb.controllers;

import de.tekup.locationappb.entites.User;
import de.tekup.locationappb.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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

        user.setUserPassword(userService.getEncodedPassword(user.getUserPassword()));
        return userService.userRegister(user);
    }

    @GetMapping("/foradmin")
    @PreAuthorize("hasRole('Admin')")
    @ResponseBody
    public String forAdmin(){
        System.out.println("wselet");
        return "this is for admin";
    }

    @GetMapping("/foruser")
    @ResponseBody
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "this is for user";
    }

}
