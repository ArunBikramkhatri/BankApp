package com.bankapplication.Repo;

import com.bankapplication.Entities.BankDetails;
import com.bankapplication.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.phone = :phone")
    User findByPhone(@Param("phone") String phone);

    @Query("select u from User u where u.bankDetails.bank_no = :bank_no")
    User findByBankDetails(@Param("bank_no") String bank_no);


}
