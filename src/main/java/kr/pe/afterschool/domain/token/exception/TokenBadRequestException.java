package kr.pe.afterschool.domain.token.exception;

import kr.pe.afterschool.domain.token.error.TokenExceptionCode;
import kr.pe.afterschool.global.error.AfterSchoolException;

public class TokenBadRequestException extends AfterSchoolException {

    private TokenBadRequestException() {
        super(TokenExceptionCode.TOKEN_BAD_REQUEST);
    }

    public static final AfterSchoolException EXCEPTION = new TokenBadRequestException();
}
