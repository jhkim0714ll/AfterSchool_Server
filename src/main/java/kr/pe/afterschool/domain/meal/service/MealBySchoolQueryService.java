package kr.pe.afterschool.domain.meal.service;

import kr.pe.afterschool.global.error.exception.InternalServerException;
import kr.pe.afterschool.thirdparth.feign.client.Neis;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MealBySchoolQueryService {

    private final Neis neis;

    @Transactional(readOnly = true)
    public String execute(Long schoolId) {
        String response = neis.getMeal(
                "13143b7ba02b4516bd9f3cbdb6fa764c",
                "json",
                1,
                100,
                "D10",
                "7240454",
                "20230405"
        );
        return response;
    }
}
