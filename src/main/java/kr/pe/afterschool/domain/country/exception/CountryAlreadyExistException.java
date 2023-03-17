package kr.pe.afterschool.domain.country.exception;

import kr.pe.afterschool.domain.country.error.CountryExceptionCode;
import kr.pe.afterschool.global.error.exception.AfterSchoolException;

public class CountryAlreadyExistException extends AfterSchoolException {

    private CountryAlreadyExistException() {
        super(CountryExceptionCode.COUNTRY_ALREADY_EXIST);
    }

    public static final AfterSchoolException EXCEPTION = new CountryAlreadyExistException();
}
