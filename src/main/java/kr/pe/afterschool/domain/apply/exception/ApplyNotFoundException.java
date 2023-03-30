package kr.pe.afterschool.domain.apply.exception;

import kr.pe.afterschool.domain.apply.error.ApplyExceptionCode;
import kr.pe.afterschool.global.error.AfterSchoolException;

public class ApplyNotFoundException extends AfterSchoolException {

    private ApplyNotFoundException() {
        super(ApplyExceptionCode.APPLY_NOT_FOUND);
    }

    public static final AfterSchoolException EXCEPTION = new ApplyNotFoundException();
}
