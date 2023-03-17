package kr.pe.afterschool.domain.school.presentation;

import kr.pe.afterschool.domain.school.presentation.dto.response.SchoolResponse;
import kr.pe.afterschool.domain.school.service.GetSchoolByCityService;
import kr.pe.afterschool.domain.school.service.GetSchoolByIdService;
import kr.pe.afterschool.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
@RequiredArgsConstructor
public class SchoolController {

    private final GetSchoolByIdService getSchoolByIdService;
    private final GetSchoolByCityService getSchoolByCityService;

    @GetMapping("/{schoolId}")
    public ResponseData<SchoolResponse> getSchoolById(
            @PathVariable Long schoolId
    ) {
        SchoolResponse response = getSchoolByIdService.execute(schoolId);
        return new ResponseData<>(
                HttpStatus.OK,
                "해당 아이디의 학교 조회 성공",
                response
        );
    }

    @GetMapping("/city")
    public ResponseData<List<SchoolResponse>> getSchoolByCity(
            @RequestParam(name = "cityName") String cityName
    ) {
        List<SchoolResponse> response = getSchoolByCityService.execute(cityName);
        return new ResponseData<>(
                HttpStatus.OK,
                "해당 도시의 학교 조회 성공",
                response
        );
    }
}
