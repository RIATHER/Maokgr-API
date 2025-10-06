package org.example.apimain.account.utils.exception;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DuplicateFieldException extends RuntimeException {

    private final List<DuplicateFields> duplicateFields = new ArrayList<>();

    public void addFieldError(String fieldName, String message) {
        this.duplicateFields.add(new DuplicateFields(fieldName, message));
    }

    public DuplicateFieldException() {}

    public record DuplicateFields(String field, String message) {}
}