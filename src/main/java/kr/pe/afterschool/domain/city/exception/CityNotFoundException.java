package kr.pe.afterschool.domain.city.exception;

import kr.pe.afterschool.domain.city.error.CityExceptionCode;
import kr.pe.afterschool.global.error.exception.AfterSchoolException;

public class CityNotFoundException extends AfterSchoolException {

    private CityNotFoundException() {
        super(CityExceptionCode.CITY_NOT_FOUND);
    }

    public static final AfterSchoolException EXCEPTION = new CityNotFoundException();
}
