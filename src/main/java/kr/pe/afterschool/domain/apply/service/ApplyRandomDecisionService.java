package kr.pe.afterschool.domain.apply.service;

import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.apply.entity.Apply;
import kr.pe.afterschool.domain.apply.entity.repository.ApplyRepository;
import kr.pe.afterschool.domain.classroom.entity.repository.ClassroomRepository;
import kr.pe.afterschool.domain.classroom.exception.ClassroomNotFoundException;
import kr.pe.afterschool.domain.apply.presentation.dto.request.ApplyDecisionRequest;
import kr.pe.afterschool.global.enums.ApplyStatus;
import kr.pe.afterschool.global.lib.RandomNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplyRandomDecisionService {

    private final ClassroomRepository classroomRepository;
    private final ApplyRepository applyRepository;
    private final RandomNumber randomNumber;

    @Transactional
    public void execute(ApplyDecisionRequest request) {
        Classroom classroom = classroomRepository.findById(request.getClassroomId())
                .orElseThrow(() -> ClassroomNotFoundException.EXCEPTION);
        List<Apply> applyList = applyRepository.findByClassroomAndStatus(classroom, ApplyStatus.PENDING);

        for (Apply apply : applyList) {
            apply.editStatus(ApplyStatus.DENIED);
        }

        int peopleLimit = applyList.size() < request.getPeopleLimit() ? applyList.size() : request.getPeopleLimit();

        int[] applyNumberList = randomNumber.a(peopleLimit, applyList.size());
        for (int i : applyNumberList) {
            applyList.get(i).editStatus(ApplyStatus.ALLOWED);
        }
        applyRepository.saveAll(applyList);
    }
}
