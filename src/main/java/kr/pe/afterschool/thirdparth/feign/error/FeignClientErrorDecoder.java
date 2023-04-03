package kr.pe.afterschool.thirdparth.feign.error;

import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import kr.pe.afterschool.thirdparth.feign.exception.*;

public class FeignClientErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) throws FeignException {
        if(response.status() >= 400) {
            switch (response.status()){
                case 400:
                    throw OtherBadRequestException.EXCEPTION;
                case 401:
                    throw OtherUnAuthorizedException.EXCEPTION;
                case 403:
                    throw OtherForbiddenException.EXCEPTION;
                case 404:
                    throw OtherNotfoundException.EXCEPTION;
                default:
                    throw OtherServerErrorException.EXCEPTION;
            }
        }

        return FeignException.errorStatus(methodKey, response);
    }
}