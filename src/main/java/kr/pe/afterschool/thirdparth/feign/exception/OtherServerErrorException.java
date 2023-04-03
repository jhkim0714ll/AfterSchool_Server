package kr.pe.afterschool.thirdparth.feign.exception;

import kr.pe.afterschool.global.error.AfterSchoolException;
import kr.pe.afterschool.thirdparth.feign.error.FeignErrorCode;

public class OtherServerErrorException extends AfterSchoolException {

    private OtherServerErrorException() {
        super(FeignErrorCode.OTHER_SERVER_ERROR);
    }

    public static final AfterSchoolException EXCEPTION = new OtherServerErrorException();
}
