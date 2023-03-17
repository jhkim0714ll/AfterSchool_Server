package kr.pe.afterschool.domain.country.exception;

import kr.pe.afterschool.domain.country.error.CountryExceptionCode;
import kr.pe.afterschool.global.error.exception.AfterSchoolException;

public class CountryNotFoundException extends AfterSchoolException {

    private CountryNotFoundException() {
        super(CountryExceptionCode.COUNTRY_NOT_FOUND);
    }

    public static final AfterSchoolException EXCEPTION = new CountryNotFoundException();
}
