package kr.pe.afterschool.domain.survey.exception;

import kr.pe.afterschool.domain.survey.error.SurveyExceptionCode;
import kr.pe.afterschool.global.error.AfterSchoolException;

public class SurveyNotFoundException extends AfterSchoolException {

    private SurveyNotFoundException() {
        super(SurveyExceptionCode.SURVEY_NOT_FOUND);
    }

    public static final AfterSchoolException EXCEPTION = new SurveyNotFoundException();
}
