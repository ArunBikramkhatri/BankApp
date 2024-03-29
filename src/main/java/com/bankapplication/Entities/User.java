package com.bankapplication.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String password;
    private String phone;

    private String email;


    private String role;
    @OneToOne
    @JoinColumn(name = "bank_no")
    private BankDetails bankDetails;

    @Override
    public String toString() {
        return "User{" +

                ", name='" + name + '\'' +

                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                " bank_no = " + bankDetails.getBank_no() +

                '}';
    }
}
