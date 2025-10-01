package org.example.apimain.account.controllers;

import org.example.apimain.account.DTO.AccountDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/account")
public class RegistrationController {

    // Запрос на регистрацию
    @PostMapping("/registration")
    public ResponseEntity<AccountDTO> Registration(@RequestBody AccountDTO accountDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountDTO);
    }
}