package kr.pe.afterschool.domain.classroom.exception;

import kr.pe.afterschool.domain.classroom.error.ClassroomExceptionCode;
import kr.pe.afterschool.global.error.AfterSchoolException;

public class ClassroomApplyNotFoundException extends AfterSchoolException {

    private ClassroomApplyNotFoundException() {
        super(ClassroomExceptionCode.CLASSROOM_APPLY_NOT_FOUND);
    }

    public static final AfterSchoolException EXCEPTION = new ClassroomApplyNotFoundException();
}
