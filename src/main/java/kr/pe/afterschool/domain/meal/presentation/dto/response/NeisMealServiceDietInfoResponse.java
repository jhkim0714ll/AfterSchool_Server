package kr.pe.afterschool.domain.meal.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NeisMealServiceDietInfoResponse {

    private Head[] head;
    private Row[] row;

    @Getter
    @AllArgsConstructor
    public static class Head {
        private Long listTotalCount;
        private Result result;
    }

    @Getter
    @AllArgsConstructor
    public static class Result {
        private String code;
        private String message;
    }

    @Getter
    @AllArgsConstructor
    public static class Row {
        private String atptOfcdcScCode;
        private String atptOfcdcScNm;
        private String sdSchulCode;
        private String schulNm;
        private String mmealScCode;
        private String mmealScNm;
        private String mlsvYmd;
        private String mlsvFgr;
        private String ddishNm;
        private String orplcInfo;
        private String calInfo;
        private String ntrInfo;
        private String mlsvFromYmd;
        private String mlsvToYmd;
    }
}
