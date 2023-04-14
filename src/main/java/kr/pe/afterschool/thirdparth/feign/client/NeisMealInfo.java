package kr.pe.afterschool.thirdparth.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "NeisMealInfo", url = "https://open.neis.go.kr")
public interface NeisMealInfo {

    @GetMapping(value = "/hub/mealServiceDietInfo")
    String getMealInfo(
            @RequestParam(name = "KEY") String key,
            @RequestParam(name = "Type") String type,
            @RequestParam(name = "pIndex") int pIndex,
            @RequestParam(name = "pSize") int pSize,
            @RequestParam(name = "ATPT_OFCDC_SC_CODE") String scCode,
            @RequestParam(name = "SD_SCHUL_CODE") String schoolCode,
            @RequestParam(name = "MLSV_YMD") String ymdSTr
    );
}
