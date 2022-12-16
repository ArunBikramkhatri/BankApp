package com.bankapplication.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/e-bank")
public class BankController {

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
}
