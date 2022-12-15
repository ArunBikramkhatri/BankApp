package com.bankapplication.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.service.annotation.GetExchange;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Bank_Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String password;
    private Long phone;

    private String email;

    private String role;

}
