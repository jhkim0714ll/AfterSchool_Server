package kr.pe.afterschool.global.lib;

import kr.pe.afterschool.global.error.exception.DateParserException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DateParser {

    public LocalDate parseStringToDate(String stringDate) {
        try {
            return LocalDate.parse(stringDate, DateTimeFormatter.ISO_DATE);
        } catch(Exception e) {
            throw DateParserException.EXCEPTION;
        }
    }
}
