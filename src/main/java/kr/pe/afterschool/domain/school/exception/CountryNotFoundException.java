package kr.pe.afterschool.domain.school.exception;

import kr.pe.afterschool.domain.school.error.SchoolExceptionCode;
import kr.pe.afterschool.global.error.exception.AfterSchoolException;

public class CountryNotFoundException extends AfterSchoolException {

    private CountryNotFoundException() {
        super(SchoolExceptionCode.COUNTRY_NOT_FOUND);
    }

    public static final AfterSchoolException EXCEPTION = new CountryNotFoundException();
}
