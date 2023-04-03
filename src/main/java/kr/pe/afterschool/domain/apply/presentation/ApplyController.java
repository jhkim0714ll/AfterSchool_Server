package kr.pe.afterschool.domain.apply.presentation;

import kr.pe.afterschool.domain.apply.service.*;
import kr.pe.afterschool.domain.apply.presentation.dto.request.ApplyCreateRequest;
import kr.pe.afterschool.domain.apply.presentation.dto.request.ApplyDecisionRequest;
import kr.pe.afterschool.domain.apply.presentation.dto.response.ApplyResponse;
import kr.pe.afterschool.global.enums.ApplyStatus;
import kr.pe.afterschool.global.response.Response;
import kr.pe.afterschool.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/apply")
@RequiredArgsConstructor
public class ApplyController {

    private final MyApplyQueryService myApplyQueryService;
    private final ApplyStatusQueryService applyStatusQueryService;
    private final ApplyCreateService applyCreateService;
    private final AppyDeleteService appyDeleteService;
    private final ApplyDecisionService applyDecisionService;
    private final ApplyRandomDecisionService applyRandomDecisionService;
    private final ApplyExcelQueryService applyExcelQueryService;

    @GetMapping("/my")
    public ResponseData<List<ApplyResponse>> getMyApply() {
        List<ApplyResponse> response = myApplyQueryService.execute();
        return new ResponseData<>(
                HttpStatus.OK,
                "내 방과후 신청 내역 조회 성공",
                response
        );
    }

    @GetMapping
    public ResponseData<List<ApplyResponse>> getApplyStatus(
            @RequestParam("classroomId") Long classroomId,
            @RequestParam("status") ApplyStatus status
    ) {
        List<ApplyResponse> response = applyStatusQueryService.execute(classroomId, status);
        return new ResponseData<>(
                HttpStatus.OK,
                "타입 값의 방과후 신청 유저 조회 성공",
                response
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Response applyClassroom(
            @RequestBody @Valid ApplyCreateRequest request
    ) {
        applyCreateService.execute(request);
        return new Response(
                HttpStatus.CREATED,
                "방과후 신청 성공"
        );
    }

    @DeleteMapping("/{classroomUserId}")
    public Response deleteApply(
            @PathVariable Long classroomUserId
    ) {
        appyDeleteService.execute(classroomUserId);
        return new Response(
                HttpStatus.OK,
                "방과후 신청 내역 삭제 성공"
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/decision/{classroomId}")
    public Response decideApply(
            @PathVariable Long classroomId
    ) {
        applyDecisionService.execute(classroomId);
        return new Response(
                HttpStatus.CREATED,
                "방과후 신청 인원 결정 성공"
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/decision/random")
    public Response decideApplyByRandom(
            @RequestBody @Valid ApplyDecisionRequest request
    ) {
        applyRandomDecisionService.execute(request);
        return new Response(
                HttpStatus.CREATED,
                "방과후 신청 인원 추첨으로 결정 성공"
        );
    }

    @GetMapping("/excel/{schoolId}")
    public void getApplierByExcel(
            @PathVariable Long schoolId
    ) {
        applyExcelQueryService.execute(schoolId);
    }
}
