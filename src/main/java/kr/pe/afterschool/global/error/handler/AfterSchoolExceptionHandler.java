package kr.pe.afterschool.global.error.handler;

import kr.pe.afterschool.global.error.AfterSchoolException;
import kr.pe.afterschool.global.response.Response;
import kr.pe.afterschool.global.response.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AfterSchoolExceptionHandler {

    @ExceptionHandler(AfterSchoolException.class)
    protected ResponseEntity<ResponseError> handleAfterSchoolExceptions(AfterSchoolException e) {
        final ResponseError responseError = ResponseError.builder()
                .status(HttpStatus.valueOf(e.getErrorProperty().getStatus()))
                .message(e.getErrorProperty().getMessage())
                .build();
        return ResponseEntity.status(e.getErrorProperty().getStatus()).body(responseError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ResponseError> handleValidateExceptions(MethodArgumentNotValidException e) {
        final ResponseError responseError = ResponseError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message("누락된 값이 존재합니다")
                .build();
        return ResponseEntity.status(400).body(responseError);
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
