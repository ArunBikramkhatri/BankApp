package com.bankapplication.Controller;

import com.bankapplication.Entities.BankDetails;
import com.bankapplication.Entities.User;
import com.bankapplication.Repo.BankRepo;
import com.bankapplication.Repo.UserRepo;
import com.bankapplication.Services.BankServices;
import com.bankapplication.Services.TransactionService;
import com.bankapplication.Services.Userservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@RequestMapping("/e-bank/user/send-money")
@Controller
public class SendMoneyController {

    @Autowired
    TransactionService transactionService;
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
    public String t_detail(@RequestParam("bankNo") String bankNo, @RequestParam("amount") String amount, Principal principal, Model model) {


        System.out.println(bankNo);
        System.out.println(principal.getName());

        try {


            User user = userservices.findUserBank(bankNo);


            model.addAttribute("user", user);
            model.addAttribute("amount", amount);


        } catch (Exception e) {
            throw new RuntimeException("Bank Not found");
        }

        return "User/Transaction_details";
    }


    @GetMapping("/send-process")
    public String send_process(Principal principal, @RequestParam("bankNo") String bankNo, @RequestParam("amount") int amount) {

        System.out.println(principal.getName());

        User user1 = userservices.findUser(principal.getName());

        String sender_b_no = user1.getBankDetails().getBank_no();
        transactionService.transfer_money(sender_b_no, bankNo, amount);
        bankServices.updateAmount(sender_b_no, amount);

        return "User/Success";
    }

}
