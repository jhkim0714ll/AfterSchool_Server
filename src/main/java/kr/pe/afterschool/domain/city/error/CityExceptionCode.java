package kr.pe.afterschool.domain.city.error;

import kr.pe.afterschool.global.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum CityExceptionCode implements ErrorProperty {

    CITY_ALREADY_EXIST(403, "이미 존재하는 도시입니다"),
    CITY_NOT_FOUND(404, "해당 도시는 존재하지 않습니다"),
    ;

    private final int status;
    private final String message;
}
