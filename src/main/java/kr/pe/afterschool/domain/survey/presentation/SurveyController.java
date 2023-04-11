package kr.pe.afterschool.domain.survey.presentation;

import kr.pe.afterschool.domain.survey.presentation.dto.request.SurveyCreateRequest;
import kr.pe.afterschool.domain.survey.presentation.dto.request.SurveyEditRequest;
import kr.pe.afterschool.domain.survey.presentation.dto.response.SurveyResponse;
import kr.pe.afterschool.domain.survey.service.*;
import kr.pe.afterschool.global.response.Response;
import kr.pe.afterschool.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/survey")
@RequiredArgsConstructor
public class SurveyController {

    private final SurveyByClassroomQueryService surveyByClassroomQueryService;
    private final SurveyQueryService surveyQueryService;
    private final MySurveyQueryService mySurveyQueryService;
    private final SurveyCreateService surveyCreateService;
    private final SurveyEditService surveyEditService;
    private final SurveyExcelQueryService surveyExcelQueryService;

    @GetMapping
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

    @GetMapping("/{surveyId}")
    public ResponseData<SurveyResponse> getSurveyById(
            @PathVariable Long surveyId
    ) {
        SurveyResponse response = surveyQueryService.execute(surveyId);
        return new ResponseData<>(
                HttpStatus.OK,
                "방과후 별 설문조사 조회 성공",
                response
        );
    }

    @GetMapping("/my")
    public ResponseData<List<SurveyResponse>> getMySurvey() {
        List<SurveyResponse> response = mySurveyQueryService.execute();
        return new ResponseData<>(
                HttpStatus.OK,
                "방과후 별 설문조사 조회 성공",
                response
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Response createSurvey(
            @RequestBody @Valid SurveyCreateRequest request
    ) {
        surveyCreateService.execute(request);
        return new Response(
                HttpStatus.CREATED,
                "설문조사 생성 성공"
        );
    }

    @PatchMapping("/{surveyId}")
    public Response editSurvey(
            @PathVariable Long surveyId,
            @RequestBody SurveyEditRequest request
    ) {
        surveyEditService.execute(surveyId, request);
        return new Response(
                HttpStatus.CREATED,
                "설문조사 생성 성공"
        );
    }

    @GetMapping("/excel")
    public void getSurveyByExcel(
            @RequestParam(value = "schoolId", required = false) Long schoolId,
            @RequestParam(value = "classroomId", required = false) Long classroomId
    ) {
        surveyExcelQueryService.execute(schoolId, classroomId);
    }
}
