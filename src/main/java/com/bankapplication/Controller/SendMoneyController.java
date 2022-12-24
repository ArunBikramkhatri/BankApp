package com.bankapplication.Controller;

import com.bankapplication.Entities.BankDetails;
import com.bankapplication.Entities.User;
import com.bankapplication.Repo.BankRepo;
import com.bankapplication.Repo.UserRepo;
import com.bankapplication.Services.BankServices;
import com.bankapplication.Services.Userservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@RequestMapping("/e-bank/user/send-money")
@Controller
public class SendMoneyController {

    @Autowired
    private BankServices bankServices;
    @Autowired
    private Userservices userservices;

    private User user;

    @GetMapping("")
    public String sendMoney() {
        return "User/send_money";
    }

    @PostMapping("/transaction-details")
    public String t_detail(@RequestParam("bankNo") String bankNo, @RequestParam("amount") String amount, Principal principal) {


//        System.out.println(bankNo);
        BankDetails bankDetails = bankServices.findBank(bankNo);
//        System.out.println(bankDetails.toString());
        user = userservices.findUserBank(bankDetails);
//        System.out.println(user.toString());

        System.out.println(principal.getName());

        return "User/Transaction_details";
    }

    @GetMapping("/send-process")
    public String send_process(Principal principal) {


        return "User/Success";
    }

}
