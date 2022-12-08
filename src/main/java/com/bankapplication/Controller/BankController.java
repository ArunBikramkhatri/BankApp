package com.bankapplication.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/e-bank/")
public class BankController {

    @GetMapping("home")
    public String homepage(){
        return "homepage";
    }

}
