package org.example.apimain.account.service;

import lombok.RequiredArgsConstructor;
import org.example.apimain.account.DTO.AccountDTO;
import org.example.apimain.account.entities.AccountEntity;
import org.example.apimain.account.repositories.AccountRepository;
import org.example.apimain.account.utils.AccountMapper;
import org.example.apimain.account.utils.exception.DuplicateFieldException;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountEntity registrationAccount(AccountDTO accountDTO) {
        validateRegistration(accountDTO);
        return accountRepository.save(accountMapper.toEntity(accountDTO));
    }

    protected void validateRegistration(AccountDTO accountDTO) {
        DuplicateFieldException duplicateFieldException = new DuplicateFieldException();
        Stream.of(
            Map.entry("username", accountRepository.existsByUsername(accountDTO.getUsername())),
            Map.entry("email", accountRepository.existsByEmail(accountDTO.getEmail())))
        .filter(Map.Entry::getValue).forEach(entry ->
             duplicateFieldException.addFieldError(entry.getKey(), "Уже существует")
        );
        if (!duplicateFieldException.getDuplicateFields().isEmpty()){
            throw duplicateFieldException;
        }
    }
}