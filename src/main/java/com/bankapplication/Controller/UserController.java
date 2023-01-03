package com.bankapplication.Controller;

import com.bankapplication.Entities.User;
import com.bankapplication.Services.Userservices;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/e-bank/user")
public class UserController {

    @Autowired
    private Userservices userservices;

    @ModelAttribute
    public void getUserData(Principal principal, Model model) {
        User user = userservices.findUser(principal.getName());
        model.addAttribute("current_user", user);
    }

    @GetMapping("/dashboard")
    public String user_dash() {


//


        return "User/User_Dashboard";
    }


}

