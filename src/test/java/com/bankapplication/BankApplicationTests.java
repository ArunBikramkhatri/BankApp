package com.bankapplication;

import com.bankapplication.Entities.BankDetails;
import com.bankapplication.Entities.User;
import com.bankapplication.Services.BankServices;
import com.bankapplication.Services.TransactionService;
import com.bankapplication.Services.Userservices;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BankApplicationTests {

    @Autowired
    private Userservices userservices;
    @Autowired
    private BankServices bankServices;

    @Autowired
    private TransactionService transactionService;

    @Test
    void contextLoads() {


        bankServices.updateAmount("293258", 100000);

        bankServices.updateAmount("7977522", 100000);
    }


}
