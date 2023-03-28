package kr.pe.afterschool.domain.classroom.exception;

import kr.pe.afterschool.domain.classroom.error.ClassroomExceptionCode;
import kr.pe.afterschool.global.error.AfterSchoolException;

public class ClassroomCannotManageException extends AfterSchoolException {

    private ClassroomCannotManageException() {
        super(ClassroomExceptionCode.CLASSROOM_CANNOT_MANAGE);
    }

    public static final AfterSchoolException EXCEPTION = new ClassroomCannotManageException();
}
