package kr.pe.afterschool.domain.apply.service;

import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.classroom.entity.repository.ClassroomRepository;
import kr.pe.afterschool.domain.apply.entity.repository.ApplyRepository;
import kr.pe.afterschool.domain.classroom.exception.ClassroomNotFoundException;
import kr.pe.afterschool.domain.apply.presentation.dto.response.ApplyResponse;
import kr.pe.afterschool.global.enums.ApplyStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplyStatusQueryService {

    private final ClassroomRepository classroomRepository;
    private final ApplyRepository applyRepository;

    @Transactional(readOnly = true)
    public List<ApplyResponse> execute(Long classroomId, ApplyStatus status) {
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(() -> ClassroomNotFoundException.EXCEPTION);
        return applyRepository.findByClassroomAndStatus(classroom, status)
                .stream().map(ApplyResponse::new).collect(Collectors.toList());
    }
}
