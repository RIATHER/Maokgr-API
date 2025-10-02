package org.example.apimain.account.service;

import lombok.RequiredArgsConstructor;
import org.example.apimain.account.DTO.AccountDTO;
import org.example.apimain.account.entities.AccountEntity;
import org.example.apimain.account.repositories.AccountRepository;
import org.example.apimain.account.utils.AccountMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountEntity registrationAccount(AccountDTO accountDTO) {
        return accountMapper.toEntity(accountDTO);
    }
}