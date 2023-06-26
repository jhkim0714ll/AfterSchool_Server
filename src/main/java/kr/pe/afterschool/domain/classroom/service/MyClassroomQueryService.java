package kr.pe.afterschool.domain.classroom.service;

import kr.pe.afterschool.domain.classroom.entity.repository.ClassroomRepository;
import kr.pe.afterschool.domain.classroom.presentation.dto.response.ClassroomResponse;
import kr.pe.afterschool.domain.school.entity.School;
import kr.pe.afterschool.domain.school.entity.repository.SchoolRepository;
import kr.pe.afterschool.domain.school.exception.SchoolNotFoundException;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyClassroomQueryService {

    private final ClassroomRepository classroomRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public List<ClassroomResponse> execute() {
        User user = userFacade.getCurrentUser();
        return classroomRepository.findByTeacher(user)
                .stream().map(ClassroomResponse::new).collect(Collectors.toList());
    }
}
