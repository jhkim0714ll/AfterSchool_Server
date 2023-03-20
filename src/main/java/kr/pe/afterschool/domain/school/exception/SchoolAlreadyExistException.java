package kr.pe.afterschool.domain.school.exception;

import kr.pe.afterschool.domain.school.error.SchoolExceptionCode;
import kr.pe.afterschool.global.error.exception.AfterSchoolException;

public class SchoolAlreadyExistException extends AfterSchoolException {

    private SchoolAlreadyExistException() {
        super(SchoolExceptionCode.SCHOOL_ALREADY_EXIST);
    }

    public static final AfterSchoolException EXCEPTION = new SchoolAlreadyExistException();
}
