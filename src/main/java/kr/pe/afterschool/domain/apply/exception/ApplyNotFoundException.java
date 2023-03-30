package kr.pe.afterschool.domain.apply.exception;

import kr.pe.afterschool.domain.classroom.error.ClassroomExceptionCode;
import kr.pe.afterschool.global.error.AfterSchoolException;

public class ApplyNotFoundException extends AfterSchoolException {

    private ApplyNotFoundException() {
        super(ClassroomExceptionCode.CLASSROOM_APPLY_NOT_FOUND);
    }

    public static final AfterSchoolException EXCEPTION = new ApplyNotFoundException();
}
