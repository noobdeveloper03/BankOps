package com.demo.BankOps.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name="account")
public class Account {

    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="account_id")
    @Id
    private Long accountId;

    @Getter
    @Setter
    @Column(name="account_No")
    private String accountNo;


    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private BankUser bankUser;

    @Getter
    @Setter
    @Column(name="balance")
    private Double balance;

    @Getter
    @Setter
    @Column(name="type")
    private String type;

    @JsonIgnore
    @Getter
    @Setter
    @CreationTimestamp
    @Column(name="createdAt")
    private LocalDateTime createdAt;

    @JsonIgnore
    @Getter
    @Setter
    @UpdateTimestamp
    @Column(name="modifiedAt")
    private LocalDateTime modifiedAt;
}
