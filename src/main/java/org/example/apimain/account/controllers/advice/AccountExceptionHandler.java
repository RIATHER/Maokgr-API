package org.example.apimain.account.controllers.advice;

import org.example.apimain.account.utils.exception.DuplicateFieldException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.validation.FieldError;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;

/// Код ошибки 409 - Ошибка уникальности полей
@RestControllerAdvice
public class AccountExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(AccountExceptionHandler.class);
    // Валидация имя пользователя, почты, пароля, по размеру, по пустоте, по формату почты
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidException(MethodArgumentNotValidException ex) {
        log.warn("Ошибка валидации");
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        log.debug(errors.toString());
        Map<String, Object> response = Map.of(
                "code", "VALIDATION_ERROR",
                "errors", errors
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    // Валидация на дубликаты имя пользователя и почты в БД
    @ExceptionHandler(DuplicateFieldException.class)
    public ResponseEntity<?> handleDuplicateFieldException(DuplicateFieldException ex) {
        log.warn("Имя пользователя или почта уже существуют");
        Map<String, String> errors = new HashMap<>();
        for (DuplicateFieldException.DuplicateFields fieldError : ex.getDuplicateFields()){
            errors.put(fieldError.field(), fieldError.message());
        }
        log.debug(errors.toString());
        Map<String, Object> response = Map.of(
                "code", "DUPLICATE_FIELD_ERROR",
                "errors", errors
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
}