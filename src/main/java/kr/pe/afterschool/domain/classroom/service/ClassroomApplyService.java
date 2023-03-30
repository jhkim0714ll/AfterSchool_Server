package kr.pe.afterschool.domain.classroom.service;

import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.classroom.entity.ClassroomApply;
import kr.pe.afterschool.domain.classroom.entity.repository.ClassroomRepository;
import kr.pe.afterschool.domain.classroom.entity.repository.ClassroomApplyRepository;
import kr.pe.afterschool.domain.classroom.exception.ClassroomNotFoundException;
import kr.pe.afterschool.domain.classroom.presentation.dto.request.ClassroomApplyRequest;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClassroomApplyService {

    private final ClassroomRepository classroomRepository;
    private final ClassroomApplyRepository classroomApplyRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(ClassroomApplyRequest request) {
        User user = userFacade.getCurrentUser();
        Classroom classroom = classroomRepository.findById(request.getClassroomId())
                .orElseThrow(() -> ClassroomNotFoundException.EXCEPTION);
        ClassroomApply classroomApply = ClassroomApply.builder()
                .student(user)
                .classroom(classroom)
                .build();
        classroomApplyRepository.save(classroomApply);
    }
}