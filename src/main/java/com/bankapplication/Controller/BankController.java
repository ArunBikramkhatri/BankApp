package com.bankapplication.Controller;


import com.bankapplication.Entities.User;
import com.bankapplication.Services.Userservices;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/e-bank")
public class BankController {

    @Autowired
    private Userservices userServices;


    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/")
    public String homepage(){
        return "homepage";
    }

    @GetMapping("/signIn")
    public ModelAndView signIn(){
        return new ModelAndView("signIn");
    }



    @GetMapping("/register")
    public ModelAndView register(){
        return new ModelAndView("Register");
    }

    @PostMapping("/register-process")
    public String register_process(@ModelAttribute("user") User user , Model model){

        if(userServices.findUser(user.getPhone()) != null){
            System.out.print("User already exist");
            return "register";
        }

        else{

            user.setRole("ROLE_USER");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userServices.saveUser(user);

            model.addAttribute(new User());


        return "signIn"; }
    }
}
