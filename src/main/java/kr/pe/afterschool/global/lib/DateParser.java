package kr.pe.afterschool.global.lib;

import kr.pe.afterschool.global.error.exception.DateParserException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
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

    public String parseWeekToKoreanWeek(DayOfWeek week) {
        switch (week) {
            case MONDAY:
                return "월요일";
            case TUESDAY:
                return "화요일";
            case WEDNESDAY:
                return "수요일";
            case THURSDAY:
                return "목요일";
            case FRIDAY:
                return "금요일";
            case SATURDAY:
                return "토요일";
            case SUNDAY:
                return "일요일";
            default:
                return "시스템 에러";
        }
    }
}
