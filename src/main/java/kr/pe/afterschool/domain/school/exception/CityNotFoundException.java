package kr.pe.afterschool.domain.school.exception;

import kr.pe.afterschool.domain.school.error.SchoolExceptionCode;
import kr.pe.afterschool.global.error.exception.AfterSchoolException;

public class CityNotFoundException extends AfterSchoolException {

    private CityNotFoundException() {
        super(SchoolExceptionCode.CITY_NOT_FOUND);
    }

    public static final AfterSchoolException EXCEPTION = new CityNotFoundException();
}
