package kr.pe.afterschool.domain.classroom.presentation;

import kr.pe.afterschool.domain.classroom.presentation.dto.request.ClassroomCreateRequest;
import kr.pe.afterschool.domain.classroom.presentation.dto.request.ClassroomEditRequest;
import kr.pe.afterschool.domain.classroom.presentation.dto.response.ClassroomResponse;
import kr.pe.afterschool.domain.classroom.service.*;
import kr.pe.afterschool.global.response.Response;
import kr.pe.afterschool.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/classrooms")
@RequiredArgsConstructor
public class ClassroomController {

    private final ClassroomIdQueryService classroomIdQueryService;
    private final ClassroomDateQueryService classroomDateQueryService;
    private final ClassroomCreateService classroomCreateService;
    private final ClassroomEditService classroomEditService;
    private final ClassroomDeleteService classroomDeleteService;

    @GetMapping("/{id}")
    public ResponseData<ClassroomResponse> getClassroomById(
            @PathVariable Long id
    ) {
        ClassroomResponse response = classroomIdQueryService.execute(id);
        return new ResponseData<>(
                HttpStatus.OK,
                "해당 아이디의 방과후 조회 성공",
                response
        );
    }

    @GetMapping("/date")
    public ResponseData<List<ClassroomResponse>> getClassroomByDate(
            @RequestParam("date") String date
    ) {
        List<ClassroomResponse> response = classroomDateQueryService.execute(date);
        return new ResponseData<>(
                HttpStatus.OK,
                "해당 날짜 방과후 조회 성공",
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
                "방과후 정보 수정 성공"
        );
    }

    @DeleteMapping("/{classroomId}")
    public Response deleteClassroom(
            @PathVariable Long classroomId
    ) {
        classroomDeleteService.execute(classroomId);
        return new Response(
                HttpStatus.OK,
                "방과후 삭제 성공"
        );
    }
}
