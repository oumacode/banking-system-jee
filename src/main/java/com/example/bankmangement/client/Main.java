package com.example.bankmangement.client;

import com.example.bankmangement.ejb.AccountService;
import com.example.bankmangement.entity.Account;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.List;
import java.util.Properties;
public class Main {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();

        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        props.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");

        Context context = new InitialContext(props);
        AccountService accountService = (AccountService)context.lookup("java:module/AccountService");

        // Ajouter des comptes
        Account account1 = new Account();
        account1.setAccountNumber("123456");
        account1.setOwnerName("Nabil Alami");
        account1.setBalance(5000.0);
        accountService.createAccount(account1);

        Account account2 = new Account();
        account2.setAccountNumber("789012");
        account2.setOwnerName("Amine Lahcen");
        account2.setBalance(3000.0);
        accountService.createAccount(account2);

        // Dépôt 
        accountService.deposit(account1.getId(), 1000.0);

        // Retrait 
        accountService.withdraw(account2.getId(), 500.0);

        // Transfert 
        accountService.transfer(account1.getId(), account2.getId(),
                200.0);

        // Liste des comptes 
        List<Account> accounts = accountService.findAllAccounts();
        for (Account account : accounts) {
            System.out.println(account.getOwnerName() + " - " +
                    account.getAccountNumber() + " : " + account.getBalance());
        }
    }
} 