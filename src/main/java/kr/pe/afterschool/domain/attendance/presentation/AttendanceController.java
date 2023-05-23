package kr.pe.afterschool.domain.attendance.presentation;

import kr.pe.afterschool.domain.attendance.presentation.dto.response.AttendanceResponse;
import kr.pe.afterschool.domain.attendance.service.AttendanceClassQueryService;
import kr.pe.afterschool.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/attendances")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceClassQueryService attendanceClassQueryService;

    @GetMapping("/{schoolId}")
    public ResponseData<List<AttendanceResponse>> getAttendanceByClass(
            @PathVariable("schoolId") Long schoolId
    ) {
        List<AttendanceResponse> response = attendanceClassQueryService.execute(schoolId);
        return new ResponseData<>(
                HttpStatus.OK,
                "해당 방과후 출석 조회 성공",
                response
        );
    }
}
