package com.example.bankmangement.ejb;

import java.util.List;
import com.example.bankmangement.entity.Account;
import jakarta.ejb.Local;

@Local
public interface AccountServiceLocal {

    void createAccount(Account account);

    List<Account> findAllAccounts();

    void deposit(Long accountId, Double amount);

}
