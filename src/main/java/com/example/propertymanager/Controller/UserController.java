package com.example.propertymanager.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @GetMapping("/admin")
    public String adminMethod(){
        return "Only Admin access";
    }

    @GetMapping("/user")
    public String userMethod(){
        return "User & Admin access";
    }
}
