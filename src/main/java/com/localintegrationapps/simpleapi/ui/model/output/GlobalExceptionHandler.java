package com.localintegrationapps.simpleapi.ui.model.output;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<RestOutputModel> handleBadRequest(IllegalArgumentException ex) {

        RestOutputModel response = new RestOutputModel(
                ApiStatus.BAD_REQUEST,
                ex.getMessage()
        );

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestOutputModel> handleGeneric(Exception ex) {

        RestOutputModel response = new RestOutputModel(
                ApiStatus.INTERNAL_ERROR,
                "Unexpected error occurred"
        );

        return ResponseEntity.status(500).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RestOutputModel> handleValidation(MethodArgumentNotValidException ex) {

        List<String> errors = new ArrayList<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }

        String errorMsg = errors.isEmpty()
                ? "Validation error"
                : String.join("; ", errors);

        return ResponseEntity.badRequest()
                .body(new RestOutputModel("400", errorMsg));
    }
}