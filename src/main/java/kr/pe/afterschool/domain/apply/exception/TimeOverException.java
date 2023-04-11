package kr.pe.afterschool.domain.apply.exception;

import kr.pe.afterschool.domain.apply.error.ApplyExceptionCode;
import kr.pe.afterschool.global.error.AfterSchoolException;

public class TimeOverException extends AfterSchoolException {

    private TimeOverException() {
        super(ApplyExceptionCode.CLASSROOM_TIME_OVER);
    }

    public static final AfterSchoolException EXCEPTION = new TimeOverException();
}
