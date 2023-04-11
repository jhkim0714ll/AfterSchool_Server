package kr.pe.afterschool.domain.survey.exception;

import kr.pe.afterschool.domain.survey.error.SurveyExceptionCode;
import kr.pe.afterschool.global.error.AfterSchoolException;

public class SurveyCannotManageException extends AfterSchoolException {

    private SurveyCannotManageException() {
        super(SurveyExceptionCode.SURVEY_CANNOT_MANAGE);
    }

    public static final AfterSchoolException EXCEPTION = new SurveyCannotManageException();
}
