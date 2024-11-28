package com.demo.BankOps.repository;

import com.demo.BankOps.dao.BankUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankUserRepository extends JpaRepository<BankUser,Long> {

    Optional<BankUser> findByName(String name);
}
