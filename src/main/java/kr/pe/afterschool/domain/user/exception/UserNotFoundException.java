package kr.pe.afterschool.domain.user.exception;

import kr.pe.afterschool.domain.user.error.UserExceptionCode;
import kr.pe.afterschool.global.error.exception.AfterSchoolException;

public class UserNotFoundException  extends AfterSchoolException {

    private UserNotFoundException() {
        super(UserExceptionCode.USER_NOT_FOUND);
    }

    public static final AfterSchoolException EXCEPTION = new UserNotFoundException();
}
