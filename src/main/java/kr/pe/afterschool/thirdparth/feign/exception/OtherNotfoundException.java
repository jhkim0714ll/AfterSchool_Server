package kr.pe.afterschool.thirdparth.feign.exception;

import kr.pe.afterschool.global.error.AfterSchoolException;
import kr.pe.afterschool.thirdparth.feign.error.FeignErrorCode;

public class OtherNotfoundException extends AfterSchoolException {

    private OtherNotfoundException() {
        super(FeignErrorCode.OTHER_NOTFOUND);
    }

    public static final AfterSchoolException EXCEPTION = new OtherNotfoundException();
}
