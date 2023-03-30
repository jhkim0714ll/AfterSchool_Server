package kr.pe.afterschool.domain.classroom.exception;

import kr.pe.afterschool.domain.classroom.error.ClassroomExceptionCode;
import kr.pe.afterschool.global.error.AfterSchoolException;

public class ClassroomPeopleOverException extends AfterSchoolException {

    private ClassroomPeopleOverException() {
        super(ClassroomExceptionCode.CLASSROOM_PEOPLE_OVER);
    }

    public static final AfterSchoolException EXCEPTION = new ClassroomPeopleOverException();
}
