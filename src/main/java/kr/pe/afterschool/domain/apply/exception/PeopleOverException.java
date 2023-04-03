package kr.pe.afterschool.domain.apply.exception;

import kr.pe.afterschool.domain.apply.error.ApplyExceptionCode;
import kr.pe.afterschool.global.error.AfterSchoolException;

public class PeopleOverException extends AfterSchoolException {

    private PeopleOverException() {
        super(ApplyExceptionCode.CLASSROOM_PEOPLE_OVER);
    }

    public static final AfterSchoolException EXCEPTION = new PeopleOverException();
}
