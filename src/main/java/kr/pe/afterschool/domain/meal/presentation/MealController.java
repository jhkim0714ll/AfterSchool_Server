package kr.pe.afterschool.domain.meal.presentation;

import kr.pe.afterschool.domain.meal.presentation.dto.response.MealResponse;
import kr.pe.afterschool.domain.meal.service.MealBySchoolQueryService;
import kr.pe.afterschool.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/meals")
@RequiredArgsConstructor
public class MealController {

    private final MealBySchoolQueryService mealBySchoolQueryService;

    @GetMapping("/{schoolId}")
    public ResponseData<List<MealResponse> > getMealBySchool(
            @PathVariable Long schoolId
    ) {
        List<MealResponse> response = mealBySchoolQueryService.execute(schoolId);
        return new ResponseData<>(
                HttpStatus.OK,
                "해당 학교 급식 조회 성공",
                response
        );
    }
}
