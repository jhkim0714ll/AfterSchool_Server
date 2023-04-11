package kr.pe.afterschool.domain.apply.service;

import kr.pe.afterschool.domain.apply.entity.Apply;
import kr.pe.afterschool.domain.apply.entity.repository.ApplyRepository;
import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.classroom.entity.repository.ClassroomRepository;
import kr.pe.afterschool.domain.classroom.exception.ClassroomNotFoundException;
import kr.pe.afterschool.global.enums.ApplyStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplyClassroomDecisionService {

    private final ClassroomRepository classroomRepository;
    private final ApplyRepository applyRepository;

    @Transactional(readOnly = true)
    public void execute(Long classroomId) {
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(() -> ClassroomNotFoundException.EXCEPTION);
        List<Apply> applyList = applyRepository.findByClassroom(classroom);
        for (Apply apply : applyList) {
            apply.editStatus(ApplyStatus.ALLOWED);
        }
        applyRepository.saveAll(applyList);
    }
}
