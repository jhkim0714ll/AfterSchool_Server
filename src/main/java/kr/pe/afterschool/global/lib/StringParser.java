package kr.pe.afterschool.global.lib;

import kr.pe.afterschool.global.error.exception.EncodeFailedException;
import org.springframework.stereotype.Component;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Component
public class StringParser {

    public String mealConvert(String originString) {
        return originString.replaceAll("\\d.", "")
                .replaceAll("[()]", "")
                .replaceAll("\\.", "")
                .replaceAll(" {2}", "")
                .replaceAll("<br/>", ", ");
    }

    public String encodeKorean(String originString) {
        try {
            return URLEncoder.encode(originString, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw EncodeFailedException.EXCEPTION;
        }
    }
}
