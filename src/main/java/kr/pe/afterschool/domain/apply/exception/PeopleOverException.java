package kr.pe.afterschool.domain.apply.exception;

import kr.pe.afterschool.domain.classroom.error.ClassroomExceptionCode;
import kr.pe.afterschool.global.error.AfterSchoolException;

public class PeopleOverException extends AfterSchoolException {

    private PeopleOverException() {
        super(ClassroomExceptionCode.CLASSROOM_PEOPLE_OVER);
    }

    public static final AfterSchoolException EXCEPTION = new PeopleOverException();
}
