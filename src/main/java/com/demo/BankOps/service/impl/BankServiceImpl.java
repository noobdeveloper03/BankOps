package com.demo.BankOps.service.impl;

import com.demo.BankOps.dao.Account;
import com.demo.BankOps.dao.BankUser;
import com.demo.BankOps.dto.BankRequest;
import com.demo.BankOps.exception.BankException;
import com.demo.BankOps.repository.AccountRepository;
import com.demo.BankOps.repository.BankUserRepository;
import com.demo.BankOps.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankServiceImpl implements BankService  {

    @Autowired
    private BankUserRepository bankRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void createBankAccount(BankRequest bankRequest) {
        BankUser bankUser = new BankUser();
        bankUser.setName(bankRequest.getName());
        Optional<BankUser> searchedBankUser = bankRepository.findByName(bankRequest.getName());
        BankUser savedBankUser = searchedBankUser.orElseGet(() -> bankRepository.save(bankUser));

        Optional<Account> searchedAccount = accountRepository.findByAccountNo(bankRequest.getAccountNo());

        if(searchedAccount.isEmpty()) {
            Account account = new Account();
            account.setAccountNo(bankRequest.getAccountNo());
            account.setBalance(bankRequest.getBalance());
            account.setType(bankRequest.getType());
            account.setBankUser(savedBankUser);
            accountRepository.save(account);
        } else {
            throw new BankException("Account No. already existed");
        }

    }

    @Override
    public List<Account> getAccountList(Long userId) {
        Optional<BankUser> bankUser = bankRepository.findById(userId);
        if(bankUser.isEmpty()) {
            throw new BankException("User Not Found");
        }
        return bankUser.get().getAccounts();
    }
}
