package kr.pe.afterschool.domain.survey.service;

import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.classroom.entity.repository.ClassroomRepository;
import kr.pe.afterschool.domain.classroom.exception.ClassroomNotFoundException;
import kr.pe.afterschool.domain.survey.entity.repository.SurveyRepository;
import kr.pe.afterschool.domain.survey.presentation.dto.response.SurveyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SurveyByClassroomQueryService {

    private final SurveyRepository surveyRepository;
    private final ClassroomRepository classroomRepository;

    @Transactional(readOnly = true)
    public List<SurveyResponse> execute(Long classroomId) {
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(() -> ClassroomNotFoundException.EXCEPTION);
        return surveyRepository.findByClassroom(classroom)
                .stream().map(SurveyResponse::new).collect(Collectors.toList());
    }
}
