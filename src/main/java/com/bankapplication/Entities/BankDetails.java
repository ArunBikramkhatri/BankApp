package com.bankapplication.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankDetails {
    @Id
    private String bank_no;

    private int amount;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bankDetails")
    private User user;


    @Override
    public String toString() {
        return "BankDetails{" +
                "bank_no='" + bank_no + '\'' +
                ", amount=" + amount +
                '}';
    }
}
