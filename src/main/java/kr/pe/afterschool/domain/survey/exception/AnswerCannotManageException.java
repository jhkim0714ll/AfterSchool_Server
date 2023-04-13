package kr.pe.afterschool.domain.survey.exception;

import kr.pe.afterschool.domain.survey.error.SurveyExceptionCode;
import kr.pe.afterschool.global.error.AfterSchoolException;

public class AnswerCannotManageException extends AfterSchoolException {

    private AnswerCannotManageException() {
        super(SurveyExceptionCode.ANSWER_CANNOT_MANAGE);
    }

    public static final AfterSchoolException EXCEPTION = new AnswerCannotManageException();
}
