package kr.pe.afterschool.domain.city.exception;

import kr.pe.afterschool.domain.city.error.CityExceptionCode;
import kr.pe.afterschool.global.error.exception.AfterSchoolException;

public class CountryNotFoundException extends AfterSchoolException {

    private CountryNotFoundException() {
        super(CityExceptionCode.COUNTRY_NOT_FOUND);
    }

    public static final AfterSchoolException EXCEPTION = new CountryNotFoundException();
}
