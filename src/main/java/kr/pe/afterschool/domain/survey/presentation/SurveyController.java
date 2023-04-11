package kr.pe.afterschool.domain.survey.presentation;

import kr.pe.afterschool.domain.survey.presentation.dto.request.AnswerCreateRequest;
import kr.pe.afterschool.domain.survey.presentation.dto.request.AnswerEditRequest;
import kr.pe.afterschool.domain.survey.presentation.dto.request.QuestionCreateRequest;
import kr.pe.afterschool.domain.survey.presentation.dto.response.AnswerResponse;
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
    private final SurveyQuestionCreateService surveyQuestionCreateService;
    private final SurveyAnswerCreateService surveyAnswerCreateService;
    private final SurveyAnswerEditService surveyAnswerEditService;
    private final SurveyAnswerExcelQueryService surveyAnswerExcelQueryService;

    @GetMapping
    public ResponseData<List<AnswerResponse>> getSurveyByClassroom(
            @RequestParam("classroomId") Long classroomId
    ) {
        List<AnswerResponse> response = surveyByClassroomQueryService.execute(classroomId);
        return new ResponseData<>(
                HttpStatus.OK,
                "방과후 별 설문조사 조회 성공",
                response
        );
    }

    @GetMapping("/{surveyId}")
    public ResponseData<AnswerResponse> getSurveyById(
            @PathVariable Long surveyId
    ) {
        AnswerResponse response = surveyQueryService.execute(surveyId);
        return new ResponseData<>(
                HttpStatus.OK,
                "방과후 별 설문조사 조회 성공",
                response
        );
    }

    @GetMapping("/my")
    public ResponseData<List<AnswerResponse>> getMySurvey() {
        List<AnswerResponse> response = mySurveyQueryService.execute();
        return new ResponseData<>(
                HttpStatus.OK,
                "방과후 별 설문조사 조회 성공",
                response
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Response createSurveyQuestion(
            @RequestBody @Valid QuestionCreateRequest request
    ) {
        surveyQuestionCreateService.execute(request);
        return new Response(
                HttpStatus.CREATED,
                "설문조사 생성 성공"
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Response createSurveyAnswer(
            @RequestBody @Valid AnswerCreateRequest request
    ) {
        surveyAnswerCreateService.execute(request);
        return new Response(
                HttpStatus.CREATED,
                "설문조사의 대답 생성 성공"
        );
    }

    @PatchMapping("/{surveyId}")
    public Response editSurveyAnswer(
            @PathVariable Long surveyId,
            @RequestBody AnswerEditRequest request
    ) {
        surveyAnswerEditService.execute(surveyId, request);
        return new Response(
                HttpStatus.OK,
                "설문조사의 대답 수정 성공"
        );
    }

    @GetMapping("/excel")
    public void getSurveyByExcel(
            @RequestParam(value = "schoolId", required = false) Long schoolId,
            @RequestParam(value = "classroomId", required = false) Long classroomId
    ) {
        surveyAnswerExcelQueryService.execute(schoolId, classroomId);
    }
}
