package kr.pe.afterschool.thirdparth.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "NeisSchoolInfo", url = "https://open.neis.go.kr")
public interface NeisSchoolInfo {

    @GetMapping(value = "/hub/schoolInfo")
    String getSchoolInfo(
            @RequestParam(name = "KEY") String key,
            @RequestParam(name = "Type") String type,
            @RequestParam(name = "pIndex") int pIndex,
            @RequestParam(name = "pSize") int pSize,
            @RequestParam(name = "SCHUL_NM") String schoolNM
    );
}
