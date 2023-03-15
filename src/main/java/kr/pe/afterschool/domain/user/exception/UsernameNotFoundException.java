package kr.pe.afterschool.domain.user.exception;

import kr.pe.afterschool.global.error.exception.AfterSchoolException;
import kr.pe.afterschool.global.error.exception.GlobalExceptionCode;

public class UsernameNotFoundException extends AfterSchoolException {

    private UsernameNotFoundException() {
        super(GlobalExceptionCode.INVALID_TOKEN);
    }

    public static final AfterSchoolException EXCEPTION = new UsernameNotFoundException();
}
