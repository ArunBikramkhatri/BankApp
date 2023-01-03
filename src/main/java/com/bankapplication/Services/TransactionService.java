package com.bankapplication.Services;

import com.bankapplication.Entities.BankDetails;
import com.bankapplication.Entities.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private BankServices bankServices;
    @Autowired
    private Userservices userservices;


    @Transactional
    public void transfer_money(String SenderAccountno, String recieverAccountno, String Samount) {

        int amount = Integer.parseInt(Samount);

        BankDetails sender = bankServices.findBank(SenderAccountno);

        BankDetails receiver = bankServices.findBank(recieverAccountno);

        int sender_amount = sender.getAmount() - amount;

        int receiver_amount = receiver.getAmount() + amount;

        bankServices.updateAmount(sender.getBank_no(), sender_amount);
        bankServices.updateAmount(receiver.getBank_no(), receiver_amount);

    }
}
