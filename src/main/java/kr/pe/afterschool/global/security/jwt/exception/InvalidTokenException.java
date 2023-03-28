package kr.pe.afterschool.global.security.jwt.exception;

import kr.pe.afterschool.global.error.AfterSchoolException;
import kr.pe.afterschool.global.error.GlobalExceptionCode;

public class InvalidTokenException extends AfterSchoolException {

    InvalidTokenException() {
        super(GlobalExceptionCode.INVALID_TOKEN);
    }

    public static final AfterSchoolException EXCEPTION = new InvalidTokenException();
}
