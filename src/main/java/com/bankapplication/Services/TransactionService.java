package com.bankapplication.Services;

import com.bankapplication.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private Userservices userservices;

    public void transfer_money(String phone, User recieverAccount, String amount) {
        User senderAccount = userservices.findUser(phone);


    }
}
