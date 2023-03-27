package kr.pe.afterschool.global.security.jwt.exception;

import kr.pe.afterschool.global.error.exception.AfterSchoolException;
import kr.pe.afterschool.global.error.exception.GlobalExceptionCode;

public class ExpiredTokenException extends AfterSchoolException {

    private ExpiredTokenException() {
        super(GlobalExceptionCode.EXPIRED_TOKEN);
    }

    public static final AfterSchoolException EXCEPTION = new ExpiredTokenException();
}
