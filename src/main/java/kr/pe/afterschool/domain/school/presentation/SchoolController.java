package kr.pe.afterschool.domain.school.presentation;

import kr.pe.afterschool.domain.school.presentation.dto.request.SchoolCreateRequest;
import kr.pe.afterschool.domain.school.presentation.dto.request.SchoolEditRequest;
import kr.pe.afterschool.domain.school.presentation.dto.response.SchoolResponse;
import kr.pe.afterschool.domain.school.service.*;
import kr.pe.afterschool.global.response.Response;
import kr.pe.afterschool.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/school")
@RequiredArgsConstructor
public class SchoolController {

    private final MySchoolQueryService mySchoolQueryService;
    private final SchoolQueryService schoolQueryService;
    private final SchoolSearchQueryService schoolSearchQueryService;
    private final SchoolCreateService schoolCreateService;
    private final SchoolEditService schoolEditService;
    private final SchoolDeleteService schoolDeleteService;

    @GetMapping("/my")
    public ResponseData<SchoolResponse> getSchoolByUser() {
        SchoolResponse response = mySchoolQueryService.execute();
        return new ResponseData<>(
                HttpStatus.OK,
                "내 학교 조회 성공",
                response
        );
    }

    @GetMapping("/{schoolId}")
    public ResponseData<SchoolResponse> getSchoolById(
            @PathVariable Long schoolId
    ) {
        SchoolResponse response = schoolQueryService.execute(schoolId);
        return new ResponseData<>(
                HttpStatus.OK,
                "해당 아이디의 학교 조회 성공",
                response
        );
    }

    @GetMapping("/search")
    public ResponseData<List<SchoolResponse>> getSchoolBySearch(
            @RequestParam(name = "address", required = false) String address,
            @RequestParam(value = "name", required = false) String name
    ) {
        List<SchoolResponse> response = schoolSearchQueryService.execute(address, name);
        return new ResponseData<>(
                HttpStatus.OK,
                "해당 도시의 학교 조회 성공",
                response
        );
    }

    @PostMapping
    public Response createSchool(
            @RequestBody @Valid SchoolCreateRequest request
    ) {
        schoolCreateService.execute(request);
        return new Response(
                HttpStatus.OK,
                "학교 생성 성공"
        );
    }

    @PatchMapping("/{schoolId}")
    public Response editSchool(
            @PathVariable Long schoolId,
            @RequestBody SchoolEditRequest request
    ) {
        schoolEditService.execute(schoolId, request);
        return new Response(
                HttpStatus.OK,
                "학교 정보 수정 성공"
        );
    }

    @DeleteMapping("/{schoolId}")
    public Response deleteSchool(
            @PathVariable Long schoolId
    ) {
        schoolDeleteService.execute(schoolId);
        return new Response(
                HttpStatus.OK,
                "학교 정보 삭제 성공"
        );
    }
}
