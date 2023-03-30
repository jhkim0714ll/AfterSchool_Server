package kr.pe.afterschool.domain.classroom.service;

import kr.pe.afterschool.domain.classroom.entity.repository.ClassroomApplyRepository;
import kr.pe.afterschool.domain.classroom.presentation.dto.response.ClassroomApplyResponse;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClassroomApplyMyQueryService {

    private final ClassroomApplyRepository classroomApplyRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public List<ClassroomApplyResponse> execute() {
        User user = userFacade.getCurrentUser();
        return classroomApplyRepository.findByStudent(user)
                .stream().map(ClassroomApplyResponse::new).collect(Collectors.toList());
    }
}
