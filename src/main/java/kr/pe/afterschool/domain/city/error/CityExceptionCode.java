package kr.pe.afterschool.domain.city.error;

import kr.pe.afterschool.global.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum CityExceptionCode implements ErrorProperty {

    CITY_NOT_FOUND(404, "해당 도시는 존재하지 않습니다"),
    COUNTRY_NOT_FOUND(404, "해당 행정 구역는 존재하지 않습니다"),
    ;

    private final int status;
    private final String message;
}
