package com.demo.BankOps.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bankuser")
public class BankUser {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;

    @Getter
    @Setter
    @Column(name="name")
    private String name;

    @Getter
    @Setter
    @OneToMany(mappedBy = "bankUser", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Account> accounts;

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
