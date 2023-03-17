package kr.pe.afterschool.domain.country.error;

import kr.pe.afterschool.global.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum CountryExceptionCode implements ErrorProperty {

    COUNTRY_NOT_FOUND(404, "해당 행정 구역는 존재하지 않습니다"),
    ;

    private final int status;
    private final String message;
}
