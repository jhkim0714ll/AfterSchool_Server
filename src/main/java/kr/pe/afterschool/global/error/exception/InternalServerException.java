package kr.pe.afterschool.global.error.exception;

import kr.pe.afterschool.global.error.AfterSchoolException;
import kr.pe.afterschool.global.error.GlobalExceptionCode;

public class InternalServerException extends AfterSchoolException {

    private InternalServerException() {
        super(GlobalExceptionCode.INTERNAL_SERVER_ERROR);
    }

    public static final AfterSchoolException EXCEPTION = new InternalServerException();
}
