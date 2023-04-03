package kr.pe.afterschool.global.lib;

import org.springframework.stereotype.Component;

@Component
public class StringParser {

    public String mealConvert(String originString) {
        return originString.replaceAll("[0-9].", "")
                .replaceAll("[()]", "")
                .replaceAll("\\.", "")
                .replaceAll("  ", "")
                .replaceAll("<br/>", ", ");
    }
}
