package com.demo.BankOps.util;

import com.demo.BankOps.dao.Account;
import com.demo.BankOps.dao.BankUser;
import com.demo.BankOps.dto.BankRequest;

import java.util.ArrayList;
import java.util.List;

public class RequestConverter {

    public static BankUser toBankUser(BankRequest bankRequest) {
        Account account = new Account();
        account.setAccountNo(bankRequest.getAccountNo());
        account.setBalance(bankRequest.getBalance());
        account.setType(bankRequest.getType());

        List<Account> accounts = new ArrayList<>();
        accounts.add(account);

        BankUser bankUser = new BankUser();
        bankUser.setName(bankRequest.getName());

        bankUser.setAccounts(accounts);
        return bankUser;
    }
}
