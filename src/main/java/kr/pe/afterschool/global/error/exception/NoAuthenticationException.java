package kr.pe.afterschool.global.error.exception;

import kr.pe.afterschool.global.error.AfterSchoolException;
import kr.pe.afterschool.global.error.GlobalExceptionCode;

public class NoAuthenticationException extends AfterSchoolException {

    private NoAuthenticationException() {
        super(GlobalExceptionCode.NO_AUTHENTICATION);
    }

    public static final AfterSchoolException EXCEPTION = new NoAuthenticationException();
}
