package kr.pe.afterschool.domain.auth.exception;

import kr.pe.afterschool.domain.auth.error.AuthExceptionCode;
import kr.pe.afterschool.global.error.AfterSchoolException;

public class WrongJoinMethodException extends AfterSchoolException {

    private WrongJoinMethodException() {
        super(AuthExceptionCode.WRONG_JOIN_METHOD);
    }

    public static final AfterSchoolException EXCEPTION = new WrongJoinMethodException();
}
