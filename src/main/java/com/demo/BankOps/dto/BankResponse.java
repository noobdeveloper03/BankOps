package com.demo.BankOps.dto;

import com.demo.BankOps.dao.Account;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankResponse {

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private List<Account> accounts;

    public BankResponse(String message) {
       this.message = message;
    }

    public BankResponse(String message,List<Account> accounts) {
        this.message = message;
        this.accounts = accounts;
    }
}
