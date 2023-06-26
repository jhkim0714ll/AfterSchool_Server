package kr.pe.afterschool.domain.classroom.service;

import kr.pe.afterschool.domain.classroom.entity.repository.ClassroomRepository;
import kr.pe.afterschool.domain.classroom.exception.ClassroomNotFoundException;
import kr.pe.afterschool.domain.classroom.presentation.dto.response.ClassroomResponse;
import kr.pe.afterschool.domain.school.entity.School;
import kr.pe.afterschool.domain.school.entity.repository.SchoolRepository;
import kr.pe.afterschool.domain.school.exception.SchoolNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClassroomSchoolQueryService {

    private final ClassroomRepository classroomRepository;
    private final SchoolRepository schoolRepository;

    @Transactional(readOnly = true)
    public List<ClassroomResponse> execute(Long schoolId) {
        School school = schoolRepository.findById(schoolId)
                .orElseThrow(() -> SchoolNotFoundException.EXCEPTION);
        return classroomRepository.findBySchool(school)
                .stream().map(ClassroomResponse::new).collect(Collectors.toList());
    }
}
