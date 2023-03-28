package kr.pe.afterschool.domain.classroom.presentation;

import kr.pe.afterschool.domain.classroom.presentation.dto.request.ClassroomCreateRequest;
import kr.pe.afterschool.domain.classroom.presentation.dto.request.ClassroomEditRequest;
import kr.pe.afterschool.domain.classroom.presentation.dto.response.ClassroomResponse;
import kr.pe.afterschool.domain.classroom.service.ClassroomByIdQueryService;
import kr.pe.afterschool.domain.classroom.service.ClassroomCreateService;
import kr.pe.afterschool.domain.classroom.service.ClassroomEditService;
import kr.pe.afterschool.global.response.Response;
import kr.pe.afterschool.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/classroom")
@RequiredArgsConstructor
public class ClassroomController {

    private final ClassroomByIdQueryService classroomByIdQueryService;
    private final ClassroomCreateService classroomCreateService;
    private final ClassroomEditService classroomEditService;

    @GetMapping("/{id}")
    public ResponseData<ClassroomResponse> getClassroomById(
            @PathVariable Long id
    ) {
        ClassroomResponse response = classroomByIdQueryService.execute(id);
        return new ResponseData<>(
                HttpStatus.OK,
                "해당 아이디의 방과후 조회 성공",
                response
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Response createClassroom(
            @RequestBody @Valid ClassroomCreateRequest request
    ) {
        classroomCreateService.execute(request);
        return new Response(
                HttpStatus.CREATED,
                "방과후 개설 성공"
        );
    }

    @PatchMapping("/{classroomId}")
    public Response editClassroom(
            @PathVariable Long classroomId,
            @RequestBody ClassroomEditRequest request
    ) {
        classroomEditService.execute(classroomId, request);
        return new Response(
                HttpStatus.OK,
                "방과후 정보 수정"
        );
    }
}
