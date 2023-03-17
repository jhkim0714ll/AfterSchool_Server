package kr.pe.afterschool.domain.school.presentation;

import kr.pe.afterschool.domain.school.presentation.dto.response.SchoolResponse;
import kr.pe.afterschool.domain.school.service.SchoolByCityQueryService;
import kr.pe.afterschool.domain.school.service.SchoolQueryService;
import kr.pe.afterschool.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolQueryService schoolQueryService;
    private final SchoolByCityQueryService schoolByCityQueryService;

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

    @GetMapping("/city")
    public ResponseData<List<SchoolResponse>> getSchoolByCity(
            @RequestParam(name = "cityName") String cityName,
            @RequestParam(name = "countryName") String countryName
    ) {
        List<SchoolResponse> response = schoolByCityQueryService.execute(cityName, countryName);
        return new ResponseData<>(
                HttpStatus.OK,
                "해당 도시의 학교 조회 성공",
                response
        );
    }
}
