package kr.pe.afterschool.global.error.exception;

import kr.pe.afterschool.global.response.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AfterSchoolExceptionHandler {

    @ExceptionHandler(AfterSchoolException.class)
    protected ResponseEntity<ResponseError> handleAfterSchoolException(AfterSchoolException e) {
        final ResponseError responseError = ResponseError.builder()
                .status(HttpStatus.valueOf(e.getErrorProperty().getStatus()))
                .message(e.getErrorProperty().getMessage())
                .build();
        return ResponseEntity.status(e.getErrorProperty().getStatus()).body(responseError);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ResponseError> handleAllLeftExceptions(Exception e) {
        final ResponseError responseError = ResponseError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(e.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseError);
    }
}
