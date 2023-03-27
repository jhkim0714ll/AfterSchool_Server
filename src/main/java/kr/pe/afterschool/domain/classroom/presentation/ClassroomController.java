package kr.pe.afterschool.domain.classroom.presentation;

import kr.pe.afterschool.domain.classroom.presentation.dto.response.ClassroomResponse;
import kr.pe.afterschool.domain.classroom.service.ClassroomByIdQueryService;
import kr.pe.afterschool.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classroom")
@RequiredArgsConstructor
public class ClassroomController {

    private final ClassroomByIdQueryService classroomByIdQueryService;

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
}
