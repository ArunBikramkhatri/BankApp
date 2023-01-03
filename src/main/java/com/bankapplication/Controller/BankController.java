package com.bankapplication.Controller;


import com.bankapplication.Entities.BankDetails;
import com.bankapplication.Entities.User;
import com.bankapplication.Services.BankServices;
import com.bankapplication.Services.Userservices;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller
@RequestMapping("/e-bank")
public class BankController {


    @Autowired
    private Userservices userServices;

    @Autowired
    private BankServices bankServices;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String homepage() {
        return "homepage";
    }


    @GetMapping("/signIn")
    public ModelAndView signIn() {
        return new ModelAndView("signIn");
    }


    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("Register");
    }

    @PostMapping("/register-process")
    public String register_process(@ModelAttribute("user") User user, Model model) {

        if (userServices.findUser(user.getPhone()) != null) {
            System.out.print("User already exist");
            return "Register";
        } else {

            //set new bank details
            BankDetails bankDetails = new BankDetails();
            Random rand = new Random();
            int bankNo = rand.nextInt(10000000);
            String bankNum = Integer.toString(bankNo);
            bankDetails.setBank_no(bankNum);
            bankDetails.setAmount(100000);

            user.setRole("ROLE_USER");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setBankDetails(bankDetails);


            bankServices.saveUserDetails(user.getBankDetails());
            userServices.saveUser(user);


            model.addAttribute(new User());


            return "signIn";
        }
    }
}
