package kr.pe.afterschool.domain.auth.exception;

import kr.pe.afterschool.domain.auth.error.AuthExceptionCode;
import kr.pe.afterschool.global.error.AfterSchoolException;

public class PasswordNotMatchException extends AfterSchoolException {

    private PasswordNotMatchException() {
        super(AuthExceptionCode.PASSWORD_NOT_MATCH);
    }

    public static final AfterSchoolException EXCEPTION = new PasswordNotMatchException();
}

