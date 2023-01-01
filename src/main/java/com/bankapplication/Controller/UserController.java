package com.bankapplication.Controller;

import com.bankapplication.Entities.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/e-bank/user")
public class UserController {

    @Autowired
    private HttpSession httpSession;

    @GetMapping("/dashboard")
    public String user_dash(Model model) {
       
        return "User/User_Dashboard";
    }


}

