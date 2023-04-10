package kr.pe.afterschool.global.error.exception;

import kr.pe.afterschool.global.error.AfterSchoolException;
import kr.pe.afterschool.global.error.GlobalExceptionCode;

public class EncodeFailedException extends AfterSchoolException {

    private EncodeFailedException() {
        super(GlobalExceptionCode.ENCODE_FAILED);
    }

    public static final AfterSchoolException EXCEPTION = new EncodeFailedException();
}
