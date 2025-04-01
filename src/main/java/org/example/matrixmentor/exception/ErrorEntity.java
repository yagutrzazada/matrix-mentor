package org.example.matrixmentor.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorEntity {
    private String message;
    private String code;
    private Map<String,String> validationErrors;
}
