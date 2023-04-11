package kr.pe.afterschool.domain.apply.exception;

import kr.pe.afterschool.domain.apply.error.ApplyExceptionCode;
import kr.pe.afterschool.global.error.AfterSchoolException;

public class AlreadyDecisionException extends AfterSchoolException {

    private AlreadyDecisionException() {
        super(ApplyExceptionCode.CLASSROOM_ALREADY_DECISION);
    }

    public static final AfterSchoolException EXCEPTION = new AlreadyDecisionException();
}
