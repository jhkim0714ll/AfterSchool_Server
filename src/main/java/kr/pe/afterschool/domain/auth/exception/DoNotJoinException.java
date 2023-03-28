package kr.pe.afterschool.domain.auth.exception;

import kr.pe.afterschool.domain.auth.error.AuthExceptionCode;
import kr.pe.afterschool.global.error.AfterSchoolException;

public class DoNotJoinException extends AfterSchoolException {

    private DoNotJoinException() {
        super(AuthExceptionCode.DO_NOT_JOIN);
    }

    public static final AfterSchoolException EXCEPTION = new DoNotJoinException();
}
