package kr.pe.afterschool.domain.city.exception;

import kr.pe.afterschool.domain.city.error.CityExceptionCode;
import kr.pe.afterschool.global.error.exception.AfterSchoolException;

public class CityAlreadyExistException extends AfterSchoolException {

    private CityAlreadyExistException() {
        super(CityExceptionCode.CITY_ALREADY_EXIST);
    }

    public static final AfterSchoolException EXCEPTION = new CityAlreadyExistException();
}
