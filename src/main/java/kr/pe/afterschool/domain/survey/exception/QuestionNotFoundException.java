package kr.pe.afterschool.domain.survey.exception;

import kr.pe.afterschool.domain.survey.error.SurveyExceptionCode;
import kr.pe.afterschool.global.error.AfterSchoolException;

public class QuestionNotFoundException extends AfterSchoolException {

    private QuestionNotFoundException() {
        super(SurveyExceptionCode.QUESTION_NOT_FOUND);
    }

    public static final AfterSchoolException EXCEPTION = new QuestionNotFoundException();
}
