package com.example.onlinebookstore.exception;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {
        List<String> errors = ex.getBindingResult().getAllErrors().stream()
                .map(e -> getErrorMessage(e))
                .toList();
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(LocalDateTime.now(),
                HttpStatus.BAD_REQUEST, errors);
        return new ResponseEntity<>(errorResponseDto, headers, status);
    }

    @ExceptionHandler(RegistrationException.class)
    public ResponseEntity<Object> handleRegistrationException(
            RegistrationException ex
    ) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(LocalDateTime.now(),
                HttpStatus.CONFLICT, List.of(ex.getMessage()));
        return new ResponseEntity<>(errorResponseDto,
                HttpStatusCode.valueOf(HttpStatus.CONFLICT.value()));
    }

    private String getErrorMessage(ObjectError e) {
        if (e instanceof FieldError) {
            String field = ((FieldError) e).getField();
            String message = e.getDefaultMessage();
            return field + " " + message;
        }
        return e.getDefaultMessage();
    }

    @Data
    private class ErrorResponseDto {
        private LocalDateTime timestamp;
        private HttpStatus status;
        private List<String> errors;

        public ErrorResponseDto(LocalDateTime timestamp, HttpStatus status, List<String> errors) {
            this.timestamp = timestamp;
            this.status = status;
            this.errors = errors;
        }
    }
}
