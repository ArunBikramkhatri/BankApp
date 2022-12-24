package com.bankapplication.Repo;

import com.bankapplication.Entities.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepo extends JpaRepository<BankDetails, Integer> {
    @Query("select b from BankDetails b where b.bank_no =:bankNo")
    BankDetails findByBankNo(@Param("bankNo") String bankNo);
}
