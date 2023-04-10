package kr.pe.afterschool.global.lib;

import kr.pe.afterschool.global.error.exception.EncodeFailedException;
import org.springframework.stereotype.Component;

import java.net.URLEncoder;

@Component
public class StringParser {

    public String mealConvert(String originString) {
        return originString.replaceAll("[0-9].", "")
                .replaceAll("[()]", "")
                .replaceAll("\\.", "")
                .replaceAll("  ", "")
                .replaceAll("<br/>", ", ");
    }

    public String encodeKorean(String originString) {
        try {
            return URLEncoder.encode(originString, "UTF-8");
        } catch (Exception e) {
            throw EncodeFailedException.EXCEPTION;
        }
    }
}
