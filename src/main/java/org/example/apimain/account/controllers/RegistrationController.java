package org.example.apimain.account.controllers;

import lombok.RequiredArgsConstructor;
import org.example.apimain.account.DTO.AccountDTO;
import org.example.apimain.account.entities.AccountEntity;
import org.example.apimain.account.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/account")
public class RegistrationController {
    private final RegistrationService registrationService;
    // Запрос на регистрацию
    @PostMapping("/registration")
    public ResponseEntity<AccountEntity> Registration(@RequestBody AccountDTO accountDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(registrationService.registrationAccount(accountDTO));
    }
}