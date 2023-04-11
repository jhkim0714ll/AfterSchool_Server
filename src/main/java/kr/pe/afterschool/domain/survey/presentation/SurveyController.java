package kr.pe.afterschool.domain.survey.presentation;

import kr.pe.afterschool.domain.survey.presentation.dto.response.SurveyResponse;
import kr.pe.afterschool.domain.survey.service.SurveyByClassroomQueryService;
import kr.pe.afterschool.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/survey")
@RequiredArgsConstructor
public class SurveyController {

    private final SurveyByClassroomQueryService surveyByClassroomQueryService;

    @GetMapping("/")
    public ResponseData<List<SurveyResponse>> getSurveyByClassroom(
            @RequestParam("classroomId") Long classroomId
    ) {
        List<SurveyResponse> response = surveyByClassroomQueryService.execute(classroomId);
        return new ResponseData<>(
                HttpStatus.OK,
                "방과후 별 설문조사 조회 성공",
                response
        );
    }
}
