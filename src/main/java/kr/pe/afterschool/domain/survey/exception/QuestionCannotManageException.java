package kr.pe.afterschool.domain.survey.exception;

import kr.pe.afterschool.domain.survey.error.SurveyExceptionCode;
import kr.pe.afterschool.global.error.AfterSchoolException;

public class QuestionCannotManageException extends AfterSchoolException {

    private QuestionCannotManageException() {
        super(SurveyExceptionCode.QUESTION_CANNOT_MANAGE);
    }

    public static final AfterSchoolException EXCEPTION = new QuestionCannotManageException();
}
