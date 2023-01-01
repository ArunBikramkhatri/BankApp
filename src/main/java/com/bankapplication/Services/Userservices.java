package com.bankapplication.Services;

import com.bankapplication.Entities.BankDetails;
import com.bankapplication.Entities.User;
import com.bankapplication.Repo.UserRepo;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor

public class Userservices {

    @Autowired
    private UserRepo userRepo;

    public Userservices(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User saveUser(User u) {
        userRepo.save(u);
        return u;
    }

    public User findUser(String phone) {

        User u = userRepo.findByPhone(phone);
        return u;
    }

    public User findUserBank(String bank_no) {
        // int bankNoInt = Integer.parseInt(bank_no);
        User user = userRepo.findByBankDetails(bank_no);
        return user;
    }
}
