package kr.pe.afterschool.domain.survey.presentation;

import kr.pe.afterschool.domain.survey.presentation.dto.request.AnswerCreateRequest;
import kr.pe.afterschool.domain.survey.presentation.dto.request.AnswerEditRequest;
import kr.pe.afterschool.domain.survey.presentation.dto.request.QuestionCreateRequest;
import kr.pe.afterschool.domain.survey.presentation.dto.request.QuestionEditRequest;
import kr.pe.afterschool.domain.survey.presentation.dto.response.AnswerResponse;
import kr.pe.afterschool.domain.survey.presentation.dto.response.QuestionResponse;
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

    private final SurveyQuestionQueryService surveyQuestionQueryService;
    private final SurveyQuestionCreateService surveyQuestionCreateService;
    private final SurveyQuestionEditService surveyQuestionEditService;
    private final SurveyAnswerByClassroomQueryService surveyAnswerByClassroomQueryService;
    private final SurveyAnswerQueryService surveyAnswerQueryService;
    private final MySurveyAnswerQueryService mySurveyAnswerQueryService;
    private final SurveyAnswerCreateService surveyAnswerCreateService;
    private final SurveyAnswerEditService surveyAnswerEditService;
    private final SurveyAnswerExcelQueryService surveyAnswerExcelQueryService;

    @GetMapping("/question/{classroomId}")
    public ResponseData<List<QuestionResponse>> getQuestionByClassroom(
            @PathVariable Long classroomId
    ) {
        List<QuestionResponse> response = surveyQuestionQueryService.execute(classroomId);
        return new ResponseData<>(
                HttpStatus.OK,
                "해당 설문조사의 질문 조회 성공",
                response
        );
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/question")
    public Response createSurveyQuestion(
            @RequestBody @Valid QuestionCreateRequest request
    ) {
        surveyQuestionCreateService.execute(request);
        return new Response(
                HttpStatus.CREATED,
                "설문조사 생성 성공"
        );
    }

    @PatchMapping("/question/{questionId}")
    public Response editSurveyQuestion(
            @PathVariable Long questionId,
            @RequestBody QuestionEditRequest request
    ) {
        surveyQuestionEditService.execute(questionId, request);
        return new Response(
                HttpStatus.OK,
                "설문조사의 질문 수정 성공"
        );
    }

    @GetMapping
    public ResponseData<List<AnswerResponse>> getAnswerByClassroom(
            @RequestParam("classroomId") Long classroomId
    ) {
        List<AnswerResponse> response = surveyAnswerByClassroomQueryService.execute(classroomId);
        return new ResponseData<>(
                HttpStatus.OK,
                "방과후 별 설문조사 조회 성공",
                response
        );
    }

    @GetMapping("/{answerId}")
    public ResponseData<AnswerResponse> getAnswerById(
            @PathVariable Long answerId
    ) {
        AnswerResponse response = surveyAnswerQueryService.execute(answerId);
        return new ResponseData<>(
                HttpStatus.OK,
                "방과후 별 설문조사 조회 성공",
                response
        );
    }

    @GetMapping("/my")
    public ResponseData<List<AnswerResponse>> getMySurveyAnswer() {
        List<AnswerResponse> response = mySurveyAnswerQueryService.execute();
        return new ResponseData<>(
                HttpStatus.OK,
                "방과후 별 설문조사 조회 성공",
                response
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

    @PatchMapping("/{answerId}")
    public Response editSurveyAnswer(
            @PathVariable Long answerId,
            @RequestBody AnswerEditRequest request
    ) {
        surveyAnswerEditService.execute(answerId, request);
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
