package org.example.matrixmentor.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public enum ErrorMessage {
    EMPLOYEE_NOT_FOUND("Employee not found with this id:%d"),
    EMPLOYEE_NOT_ACTIVE("Employee is not active"),
    VALIDATION_ERROR("Validation error");
    private final String message;
}
