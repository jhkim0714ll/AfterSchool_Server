package kr.pe.afterschool.domain.survey.error;

import kr.pe.afterschool.global.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SurveyExceptionCode implements ErrorProperty {

    ;

    private final int status;
    private final String message;
}
