package kr.pe.afterschool.domain.school.exception;

import kr.pe.afterschool.domain.school.error.SchoolExceptionCode;
import kr.pe.afterschool.global.error.exception.AfterSchoolException;

public class SchoolCannotException extends AfterSchoolException {

    private SchoolCannotException() {
        super(SchoolExceptionCode.SCHOOL_CANNOT_MANAGE);
    }

    public static final AfterSchoolException EXCEPTION = new SchoolCannotException();
}
