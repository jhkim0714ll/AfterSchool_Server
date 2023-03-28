package kr.pe.afterschool.global.error.exception;

import kr.pe.afterschool.global.error.AfterSchoolException;
import kr.pe.afterschool.global.error.GlobalExceptionCode;

public class DateParserException extends AfterSchoolException {

    private DateParserException() {
        super(GlobalExceptionCode.DATE_PARSER);
    }

    public static final AfterSchoolException EXCEPTION = new DateParserException();
}
