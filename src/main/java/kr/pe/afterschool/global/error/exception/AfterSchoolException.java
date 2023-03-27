package kr.pe.afterschool.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
abstract public class AfterSchoolException extends RuntimeException {

    private final ErrorProperty errorProperty;
}
