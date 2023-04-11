package kr.pe.afterschool.domain.apply.service;

import kr.pe.afterschool.domain.apply.entity.Apply;
import kr.pe.afterschool.domain.apply.entity.repository.ApplyRepository;
import kr.pe.afterschool.domain.apply.exception.AlreadyDecisionException;
import kr.pe.afterschool.domain.apply.exception.ApplyNotFoundException;
import kr.pe.afterschool.domain.classroom.exception.ClassroomCannotManageException;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import kr.pe.afterschool.global.enums.ApplyStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AppyDeleteService {

    private final ApplyRepository applyRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long classroomUserId) {
        User user = userFacade.getCurrentUser();
        Apply apply = applyRepository.findById(classroomUserId)
                .orElseThrow(() -> ApplyNotFoundException.EXCEPTION);
        if (user != apply.getStudent()) {
            throw ClassroomCannotManageException.EXCEPTION;
        }
        if (apply.getStatus().equals(ApplyStatus.ALLOWED)) {
            throw AlreadyDecisionException.EXCEPTION;
        }
        applyRepository.delete(apply);
    }
}
