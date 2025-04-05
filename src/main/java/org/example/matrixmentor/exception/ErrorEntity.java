package org.example.matrixmentor.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
//class adin deyis
public class ErrorEntity {
    private String message;
    private String code;
    private Map<String,String> validationErrors;
}
