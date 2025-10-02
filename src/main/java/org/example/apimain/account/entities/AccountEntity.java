package org.example.apimain.account.entities;

import jakarta.persistence.*;
import org.example.apimain.account.enums.AccountStatus;

import java.util.UUID;

@Entity
@Table(name = "accounts")
public class AccountEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password_hash")
    private String password_hash;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "account_status")
    private AccountStatus status;
}