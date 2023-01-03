package com.bankapplication.Controller;


import com.bankapplication.Entities.User;


import com.bankapplication.Services.TransactionService;
import com.bankapplication.Services.Userservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequestMapping("/e-bank/user/send-money")
@Controller
public class SendMoneyController {

    @Autowired
    TransactionService transactionService;

    @Autowired
    private Userservices userservices;


    @GetMapping("")
    public String sendMoney() {
        return "User/send_money";
    }

    @PostMapping("/transaction-details")
    public String t_detail(@RequestParam("bankNo") String bankNo, @RequestParam("amount") String amount, Principal principal, Model model) {


        System.out.println(bankNo);
        //System.out.println(principal.getName());

        try {


            User receiver = userservices.findUserBank(bankNo);
            // System.out.println(user.toString());


            model.addAttribute("user", receiver);
            model.addAttribute("amount", amount);


        } catch (Exception e) {
            throw new RuntimeException("Bank Not found");
        }

        return "User/Transaction_details";
    }


    @PostMapping("/send-process")
    public String send_process(Principal principal, @RequestParam("bank_No") String r_bank_No, @RequestParam("amount") String amount) {


//        System.out.println(amount);
//        System.out.println(principal.getName());
//        System.out.println(bank_No);
        User sender = userservices.findUser(principal.getName());
//
        String sender_b_no = sender.getBankDetails().getBank_no();
//        String receiver_b_no = receiver.getBankDetails().getBank_no();
        transactionService.transfer_money(sender_b_no, r_bank_No, amount);

        return "User/Success";
    }

}
