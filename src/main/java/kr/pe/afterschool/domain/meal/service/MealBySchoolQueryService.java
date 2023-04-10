package kr.pe.afterschool.domain.meal.service;

import kr.pe.afterschool.domain.school.entity.School;
import kr.pe.afterschool.domain.school.entity.repository.SchoolRepository;
import kr.pe.afterschool.domain.school.exception.SchoolNotFoundException;
import kr.pe.afterschool.global.error.exception.InternalServerException;
import kr.pe.afterschool.thirdparth.feign.client.Neis;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MealBySchoolQueryService {

    private final Neis neis;
    private final SchoolRepository schoolRepository;

    @Transactional(readOnly = true)
    public String execute(Long schoolId) {
        School school = schoolRepository.findById(schoolId)
                .orElseThrow(() -> SchoolNotFoundException.EXCEPTION);
        LocalDate localDate = LocalDate.now();
        String schoolInfo = neis.getSchoolInfo(school.getName());
        String mealInfo = neis.getMealInfo("", "" , "");
        return null;
    }
}
