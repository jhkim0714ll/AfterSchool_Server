package kr.pe.afterschool.global.error.exception;

public class NoAuthenticationException extends AfterSchoolException {

    private NoAuthenticationException() {
        super(GlobalExceptionCode.NO_AUTHENTICATION);
    }

    public static final AfterSchoolException EXCEPTION = new NoAuthenticationException();
}
