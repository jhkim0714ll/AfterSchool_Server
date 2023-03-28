package kr.pe.afterschool.domain.classroom.service;

import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.classroom.entity.repository.ClassroomRepository;
import kr.pe.afterschool.domain.classroom.exception.ClassroomCannotManageException;
import kr.pe.afterschool.domain.classroom.exception.ClassroomNotFoundException;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import kr.pe.afterschool.global.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClassroomDeleteService {

    private final ClassroomRepository classroomRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long classroomId) {
        User user = userFacade.getCurrentUser();
        Classroom classroom = classroomRepository.findById(classroomId)
                        .orElseThrow(() -> ClassroomNotFoundException.EXCEPTION);
        if (user.getSchool() != classroom.getSchool() || user.getRole().equals(UserRole.TEACHER)) {
            throw ClassroomCannotManageException.EXCEPTION;
        }
        classroomRepository.deleteById(classroomId);
    }
}
