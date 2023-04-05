package kr.pe.afterschool.thirdparth.feign.client;

import kr.pe.afterschool.thirdparth.feign.exception.OtherServerErrorException;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Component
public class Neis {

    public String getMeal(String key, String type, int pIndex, int pSize, String cityCode, String schoolCode, String ymStr) {
        String url = String.format(
                "https://open.neis.go.kr/hub/mealServiceDietInfo?" +
                "KEY=%s&Type=%s&pIndex=%d&pSize=%d&" +
                "ATPT_OFCDC_SC_CODE=%s&SD_SCHUL_CODE=%s&MLSV_YMD=%s",
                key, type, pIndex, pSize, cityCode, schoolCode, ymStr);
        try {
            URL uri = new URL(url);
            URLConnection conn = uri.openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            return br.readLine();
        } catch (Exception e) {
            throw OtherServerErrorException.EXCEPTION;
        }
    }
}
