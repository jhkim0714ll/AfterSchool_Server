package kr.pe.afterschool.domain.classroom.service;

import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.classroom.entity.ClassroomApply;
import kr.pe.afterschool.domain.classroom.entity.repository.ClassroomApplyRepository;
import kr.pe.afterschool.domain.classroom.entity.repository.ClassroomRepository;
import kr.pe.afterschool.domain.classroom.exception.ClassroomNotFoundException;
import kr.pe.afterschool.domain.classroom.presentation.dto.request.ClassroomDecisionRequest;
import kr.pe.afterschool.global.enums.ClassroomApplyStatus;
import kr.pe.afterschool.global.lib.RandomNumber;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClassroomDecisionService {

    private final ClassroomRepository classroomRepository;
    private final ClassroomApplyRepository classroomApplyRepository;
    private final RandomNumber randomNumber;

    @Transactional
    public void execute(ClassroomDecisionRequest request) {
        Classroom classroom = classroomRepository.findById(request.getClassroomId())
                .orElseThrow(() -> ClassroomNotFoundException.EXCEPTION);
        List<ClassroomApply> classroomApplyList = classroomApplyRepository.findByClassroomAndStatus(classroom, ClassroomApplyStatus.PENDING);

        for (ClassroomApply classroomApply : classroomApplyList) {
            classroomApply.editStatus(ClassroomApplyStatus.DENIED);
        }

        int peopleLimit = classroomApplyList.size() < request.getPeopleLimit() ? classroomApplyList.size() : request.getPeopleLimit();

        int[] applyNumberList = randomNumber.a(peopleLimit, classroomApplyList.size());
        for (int i : applyNumberList) {
            classroomApplyList.get(i).editStatus(ClassroomApplyStatus.ALLOWED);
        }
        classroomApplyRepository.saveAll(classroomApplyList);
    }
}
