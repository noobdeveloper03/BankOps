package com.demo.BankOps.controller;

import com.demo.BankOps.dao.BankUser;
import com.demo.BankOps.dto.BankRequest;
import com.demo.BankOps.dto.BankResponse;
import com.demo.BankOps.service.BankService;
import com.demo.BankOps.util.RequestConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping("/bank/account/save")
    public ResponseEntity<BankResponse> createBankAccount(@RequestBody BankRequest bankRequest) {
        bankService.createBankAccount(bankRequest);
        return new ResponseEntity<>(new BankResponse("success"), HttpStatus.OK);
    }

    @GetMapping("/bank/{userId}/accounts")
    public ResponseEntity<BankResponse> createBankAccount(@PathVariable("userId") String userId) {
        return new ResponseEntity<>(new BankResponse("success",bankService.getAccountList(Long.parseLong(userId))), HttpStatus.OK);
    }
}
