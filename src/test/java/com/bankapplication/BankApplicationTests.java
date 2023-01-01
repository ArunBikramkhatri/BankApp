package com.bankapplication;

import com.bankapplication.Entities.User;
import com.bankapplication.Services.BankServices;
import com.bankapplication.Services.Userservices;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BankApplicationTests {

    @Autowired
    private Userservices userservices;
    private BankServices bankServices;

    @Test
    void contextLoads() {
        User user = userservices.findUserBank("293258");
        System.out.println(user.toString());
    }


}
