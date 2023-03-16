package kr.pe.afterschool.domain.auth.exception;

import kr.pe.afterschool.domain.auth.error.AuthExceptionCode;
import kr.pe.afterschool.global.error.exception.AfterSchoolException;

public class AlreadyJoinException extends AfterSchoolException {

    private AlreadyJoinException() {
        super(AuthExceptionCode.ALREADY_JOIN);
    }

    public static final AfterSchoolException EXCEPTION = new AlreadyJoinException();
}
