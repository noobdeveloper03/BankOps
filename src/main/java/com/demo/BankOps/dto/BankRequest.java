package com.demo.BankOps.dto;

import com.demo.BankOps.dao.Account;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class BankRequest {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Double balance;

    @Getter
    @Setter
    private String accountNo;

    @Getter
    @Setter
    private String type;
}
