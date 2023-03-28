package kr.pe.afterschool.domain.classroom.service;

import kr.pe.afterschool.domain.classroom.entity.repository.ClassroomRepository;
import kr.pe.afterschool.domain.classroom.presentation.dto.response.ClassroomResponse;
import kr.pe.afterschool.global.security.lib.DateParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClassroomByDateQueryService {

    private final ClassroomRepository classroomRepository;
    private final DateParser dateParser;

    @Transactional(readOnly = true)
    public List<ClassroomResponse> execute(String date) {
        LocalDate endDate = dateParser.parseStringToDate(date);
        return classroomRepository.findByEndDateBetween(LocalDate.now().minusDays(1), endDate)
                .stream().map(ClassroomResponse::new).collect(Collectors.toList());
    }
}
