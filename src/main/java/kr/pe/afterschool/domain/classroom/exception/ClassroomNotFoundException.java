package kr.pe.afterschool.domain.classroom.exception;

import kr.pe.afterschool.domain.classroom.error.ClassroomExceptionCode;
import kr.pe.afterschool.global.error.AfterSchoolException;

public class ClassroomNotFoundException extends AfterSchoolException {

    private ClassroomNotFoundException() {
        super(ClassroomExceptionCode.CLASSROOM_NOT_FOUND);
    }

    public static final AfterSchoolException EXCEPTION = new ClassroomNotFoundException();
}
