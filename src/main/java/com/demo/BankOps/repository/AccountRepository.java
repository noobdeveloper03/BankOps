package com.demo.BankOps.repository;

import com.demo.BankOps.dao.Account;
import com.demo.BankOps.dao.BankUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {

    List<Account> findByBankUser(BankUser bankUser);

    Optional<Account> findByAccountNoAndBankUser(String accountNo,BankUser bankUser);

    Optional<Account> findByAccountNo(String accountNo);
}
