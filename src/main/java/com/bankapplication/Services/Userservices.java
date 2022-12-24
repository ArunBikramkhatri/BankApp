package com.bankapplication.Services;

import com.bankapplication.Entities.BankDetails;
import com.bankapplication.Entities.User;
import com.bankapplication.Repo.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor

public class Userservices {

    @Autowired
    private UserRepo userRepo;

    public Userservices(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void saveUser(User u) {
        userRepo.save(u);
    }

    public User findUser(String phone) {

        User u = userRepo.findByPhone(phone);
        return u;
    }

    public User findUserBank(BankDetails bankDetails) {
        User user = userRepo.findByBankDetails(bankDetails);
        return user;
    }
}
