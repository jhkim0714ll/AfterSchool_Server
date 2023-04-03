package kr.pe.afterschool.domain.apply.service;

import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.apply.entity.Apply;
import kr.pe.afterschool.domain.classroom.entity.repository.ClassroomRepository;
import kr.pe.afterschool.domain.apply.entity.repository.ApplyRepository;
import kr.pe.afterschool.domain.classroom.exception.ClassroomNotFoundException;
import kr.pe.afterschool.domain.apply.exception.PeopleOverException;
import kr.pe.afterschool.domain.apply.presentation.dto.request.ApplyCreateRequest;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ApplyCreateService {

    private final ClassroomRepository classroomRepository;
    private final ApplyRepository applyRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(ApplyCreateRequest request) {
        User user = userFacade.getCurrentUser();
        Classroom classroom = classroomRepository.findById(request.getClassroomId())
                .orElseThrow(() -> ClassroomNotFoundException.EXCEPTION);

        int applyNumber = applyRepository.findByClassroom(classroom).size();
        if (classroom.getPeopleLimit() <= applyNumber) {
            throw PeopleOverException.EXCEPTION;
        }

        Apply apply = Apply.builder()
                .student(user)
                .classroom(classroom)
                .build();
        applyRepository.save(apply);
    }
}
