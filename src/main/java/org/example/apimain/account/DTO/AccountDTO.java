package org.example.apimain.account.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class AccountDTO {
    @Pattern(
        regexp = "^[A-Za-z](?:[A-Za-z._-]{1,18}[A-Za-z])?$",
        message = "Допустимы только латинские буквы, точка, дефис и подчёркивание"
    )
    @Size(min = 5, max = 128, message = "Имя пользователя должен быть от 5 до 128")
    @NotBlank(message = "Имя пользователя не должно быть пустым")
    private String username;


    @NotBlank(message = "Почта не должна быть пустой")
    @Size(max = 128, message = "Почта должна быть до 128")
    @Email(message = "Должен иметь формат почты")
    private String email;

    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+=\\-{}\\[\\]:;\"'<>,.?/]).*$",
            message = "Пароль должен содержать хотя бы одну букву, одну цифру и один специальный символ"
    )
    @Size(min = 8, max = 128, message = "Пароль должен быть от 8 до 128")
    @NotBlank(message = "Пароль не должен быть пустым")
    private String password;
}