package com.bankapplication.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/e-bank/user")
public class UserController {

    @GetMapping("/dashboard")
    public String user_dash(){
        return "User/User_Dashboard";
    }
}
