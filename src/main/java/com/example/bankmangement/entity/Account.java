package com.example.bankmangement.entity;

import jakarta.persistence.*;
import java.io.Serializable;  // ← ADD THIS IMPORT

@Entity
public class Account implements Serializable {  // ← IMPLEMENT Serializable

    private static final long serialVersionUID = 1L;  // ← ADD serialVersionUID

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String accountNumber;

    private String ownerName;

    @Column(nullable = false)
    private Double balance;


    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public Double getBalance() { return balance; }
    public void setBalance(Double balance) { this.balance = balance; }

}