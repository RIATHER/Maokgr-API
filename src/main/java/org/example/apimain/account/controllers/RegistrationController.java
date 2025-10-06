package org.example.apimain.account.controllers;

import org.example.apimain.account.service.RegistrationService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.example.apimain.account.entities.AccountEntity;
import org.example.apimain.account.DTO.AccountDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/account")
public class RegistrationController {
    private final RegistrationService registrationService;
    private final Logger log = LoggerFactory.getLogger(RegistrationController.class);
    // Запрос на регистрацию
    @PostMapping("/registration")
    public ResponseEntity<AccountEntity> Registration(@Valid @RequestBody AccountDTO accountDTO) {
        log.info("Запрос на регистрацию аккаунта");
        return ResponseEntity.status(HttpStatus.CREATED).body(registrationService.registrationAccount(accountDTO));
    }
}