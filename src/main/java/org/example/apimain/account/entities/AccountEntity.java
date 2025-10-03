package org.example.apimain.account.entities;

import org.example.apimain.account.enums.AccountStatus;
import org.hibernate.annotations.JdbcTypeCode;
import com.github.f4b6a3.ulid.UlidCreator;
import org.hibernate.type.SqlTypes;
import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;

import java.util.UUID;

@Entity
@Table(name = "accounts")
@Getter
@Setter
public class AccountEntity {
    @Id
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private UUID id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String password;

    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AccountStatus status = AccountStatus.ACTIVE;

    // Добавление перед сохранением в БД
    @PrePersist
    public void prePersist(){
        if (id == null){
            this.id = UlidCreator.getMonotonicUlid().toUuid();
        }
    }
}