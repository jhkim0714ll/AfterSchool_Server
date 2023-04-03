package kr.pe.afterschool.thirdparth.feign.client;

import kr.pe.afterschool.domain.meal.presentation.dto.response.MealResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "kaKaoAuth", url = "https://kauth.kakao.com")
public interface Neis {

    @GetMapping
    MealResponse getMeal(
            @RequestParam("KEY") String key,
            @RequestParam("Type") String type,
            @RequestParam("pIndex") int pIndex,
            @RequestParam("pSize") int pSize,
            @RequestParam("ATPT_OFCDC_SC_CODE") String cityCode,
            @RequestParam("SD_SCHUL_CODE") String schoolCode,
            @RequestParam("MLSV_YMD") String ymdStr
    );
}
