package kr.pe.afterschool.thirdparth.feign.exception;

import kr.pe.afterschool.global.error.AfterSchoolException;
import kr.pe.afterschool.thirdparth.feign.error.FeignErrorCode;

public class OtherForbiddenException extends AfterSchoolException {

    private OtherForbiddenException() {
        super(FeignErrorCode.OTHER_FORBIDDEN);
    }

    public static final AfterSchoolException EXCEPTION = new OtherForbiddenException();
}
