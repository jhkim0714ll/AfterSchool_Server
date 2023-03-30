package kr.pe.afterschool.domain.classroom.service;

import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.classroom.entity.repository.ClassroomRepository;
import kr.pe.afterschool.domain.classroom.entity.repository.ClassroomUserRepository;
import kr.pe.afterschool.domain.classroom.exception.ClassroomNotFoundException;
import kr.pe.afterschool.domain.classroom.presentation.dto.response.ClassroomUserResponse;
import kr.pe.afterschool.global.enums.ClassroomUserStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClassroomUserQueryService {

    private final ClassroomRepository classroomRepository;
    private final ClassroomUserRepository classroomUserRepository;

    @Transactional(readOnly = true)
    public List<ClassroomUserResponse> execute(Long classroomId,ClassroomUserStatus status) {
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(() -> ClassroomNotFoundException.EXCEPTION);
        return classroomUserRepository.findByClassroomAndStatus(classroom, status)
                .stream().map(ClassroomUserResponse::new).collect(Collectors.toList());
    }
}
