package kr.pe.afterschool.thirdparth.feign.client;

import kr.pe.afterschool.global.config.properties.NeisProperties;
import kr.pe.afterschool.global.lib.StringParser;
import kr.pe.afterschool.thirdparth.feign.exception.OtherServerErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
public class Neis {

    private final NeisProperties neisProperties;
    private final StringParser stringParser;

    public String getSchoolInfo(String schoolName) {
        String key = neisProperties.getKey();
        String schoolNM = stringParser.encodeKorean(schoolName);
        String url = "https://open.neis.go.kr/hub/schoolInfo?KEY=" + key + "&Type=json&pIndex=1&pSize=10&SCHUL_NM=" + schoolNM;
        return executeUrl(url);
    }

    public String getMealInfo(String cityCode, String schoolCode, String ymStr) {
        String key = neisProperties.getKey();
        String url = String.format(
                "https://open.neis.go.kr/hub/mealServiceDietInfo?" +
                "KEY=%s&Type=json&pIndex=1&pSize=100&" +
                "ATPT_OFCDC_SC_CODE=%s&SD_SCHUL_CODE=%s&MLSV_YMD=%s",
                key, cityCode, schoolCode, ymStr);
        return executeUrl(url);
    }

    private String executeUrl(String url) {
        try {
            URL uri = new URL(url);
            URLConnection conn = uri.openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));

            return br.readLine();
        } catch (Exception e) {
            throw OtherServerErrorException.EXCEPTION;
        }
    }
}
