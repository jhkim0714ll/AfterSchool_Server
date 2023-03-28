package kr.pe.afterschool.domain.school.exception;

import kr.pe.afterschool.domain.school.error.SchoolExceptionCode;
import kr.pe.afterschool.global.error.AfterSchoolException;

public class SchoolNotFoundException extends AfterSchoolException {

    private SchoolNotFoundException() {
        super(SchoolExceptionCode.SCHOOL_NOT_FOUNT);
    }

    public static final AfterSchoolException EXCEPTION = new SchoolNotFoundException();
}
