package kr.pe.afterschool.domain.classroom.service;

import kr.pe.afterschool.domain.classroom.entity.ClassroomApply;
import kr.pe.afterschool.domain.classroom.entity.repository.ClassroomApplyRepository;
import kr.pe.afterschool.domain.classroom.exception.ClassroomApplyNotFoundException;
import kr.pe.afterschool.domain.classroom.exception.ClassroomCannotManageException;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClassroomUserDeleteService {

    private final ClassroomApplyRepository classroomApplyRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long classroomUserId) {
        User user = userFacade.getCurrentUser();
        ClassroomApply classroomApply = classroomApplyRepository.findById(classroomUserId)
                .orElseThrow(() -> ClassroomApplyNotFoundException.EXCEPTION);
        if (user != classroomApply.getStudent()) {
            throw ClassroomCannotManageException.EXCEPTION;
        }
        classroomApplyRepository.delete(classroomApply);
    }
}
