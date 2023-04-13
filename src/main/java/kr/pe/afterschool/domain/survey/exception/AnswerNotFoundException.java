package kr.pe.afterschool.domain.survey.exception;

import kr.pe.afterschool.domain.survey.error.SurveyExceptionCode;
import kr.pe.afterschool.global.error.AfterSchoolException;

public class AnswerNotFoundException extends AfterSchoolException {

    private AnswerNotFoundException() {
        super(SurveyExceptionCode.ANSWER_NOT_FOUND);
    }

    public static final AfterSchoolException EXCEPTION = new AnswerNotFoundException();
}
