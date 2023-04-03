package kr.pe.afterschool.thirdparth.feign.error;

import kr.pe.afterschool.global.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum FeignErrorCode implements ErrorProperty {

    OTHER_BAD_REQUEST(400, "Other Bad Request"),
    OTHER_UN_AUTHORIZED(401, "Other Un Authorized"),
    OTHER_FORBIDDEN(403, "Other Forbidden"),
    OTHER_NOTFOUND(404, "Other NotFound"),
    OTHER_SERVER_ERROR(500, "Other Server Error");

    private final int status;
    private final String message;
}
