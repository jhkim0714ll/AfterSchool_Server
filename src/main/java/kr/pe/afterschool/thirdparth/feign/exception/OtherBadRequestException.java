package kr.pe.afterschool.thirdparth.feign.exception;

import kr.pe.afterschool.global.error.AfterSchoolException;
import kr.pe.afterschool.thirdparth.feign.error.FeignErrorCode;

public class OtherBadRequestException extends AfterSchoolException {

    private OtherBadRequestException() {
        super(FeignErrorCode.OTHER_BAD_REQUEST);
    }

    public static final AfterSchoolException EXCEPTION = new OtherBadRequestException();
}
