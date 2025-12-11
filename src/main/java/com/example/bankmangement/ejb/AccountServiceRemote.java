package com.example.bankmangement.ejb;

import java.util.List;
import com.example.bankmangement.entity.Account;
import jakarta.ejb.Remote;

@Remote
public interface AccountServiceRemote {

    void createAccount(Account account);

    List<Account> findAllAccounts();

    void deposit(Long accountId, Double amount);
}