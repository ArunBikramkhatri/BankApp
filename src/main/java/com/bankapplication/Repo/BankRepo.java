package com.bankapplication.Repo;

import com.bankapplication.Entities.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepo extends JpaRepository<BankDetails, Integer> {
    @Query("select b from BankDetails b where b.bank_no =:bankNo")
    BankDetails findByBankNo(@Param("bankNo") String bankNo);

    @Modifying
    @Query("update BankDetails b set b.amount =: amount1 where b.bank_no =:bank_no")
    void updateAmount(@Param("bank_no") String bank_no, @Param("amount1") Integer amount1);
}
