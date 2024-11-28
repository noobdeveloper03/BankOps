package com.demo.BankOps.service;

import com.demo.BankOps.dao.Account;
import com.demo.BankOps.dao.BankUser;
import com.demo.BankOps.dto.BankRequest;

import java.util.List;

public interface BankService {

    void createBankAccount(BankRequest bankRequest);

    List<Account> getAccountList(Long userId);
}
