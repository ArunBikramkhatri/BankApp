package com.bankapplication;

import com.bankapplication.Entities.User;
import com.bankapplication.Services.BankServices;
import com.bankapplication.Services.Userservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankApplication {


    public static void main(String[] args) {


        SpringApplication.run(BankApplication.class, args);


    }


}
