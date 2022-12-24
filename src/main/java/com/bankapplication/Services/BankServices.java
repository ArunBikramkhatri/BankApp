package com.bankapplication.Services;

import com.bankapplication.Entities.BankDetails;
import com.bankapplication.Repo.BankRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankServices {

    @Autowired
    private final BankRepo bankRepo;

    public BankDetails findBank(String bankNo) {
        int bankNoInt = Integer.parseInt(bankNo);
        BankDetails b = bankRepo.findByBankNo(bankNo);

        System.out.println(b.toString());
        return b;


    }
}
