package kr.pe.afterschool.domain.user.exception;

import kr.pe.afterschool.domain.user.error.UserExceptionCode;
import kr.pe.afterschool.global.error.AfterSchoolException;

public class UsernameNotFoundException extends AfterSchoolException {

    private UsernameNotFoundException() {
        super(UserExceptionCode.USER_NAME_NOT_FOUND);
    }

    public static final AfterSchoolException EXCEPTION = new UsernameNotFoundException();
}
