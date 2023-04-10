package kr.pe.afterschool.thirdparth.feign.exception;

import kr.pe.afterschool.global.error.AfterSchoolException;
import kr.pe.afterschool.thirdparth.feign.error.FeignErrorCode;

public class OtherUnAuthorizedException extends AfterSchoolException {

    private OtherUnAuthorizedException() {
        super(FeignErrorCode.OTHER_UN_AUTHORIZED);
    }

    public static final AfterSchoolException EXCEPTION = new OtherUnAuthorizedException();
}
