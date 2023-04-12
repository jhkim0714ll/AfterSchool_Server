package kr.pe.afterschool.domain.survey.service;

import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.classroom.entity.repository.ClassroomRepository;
import kr.pe.afterschool.domain.classroom.exception.ClassroomNotFoundException;
import kr.pe.afterschool.domain.survey.entity.repository.QuestionRepository;
import kr.pe.afterschool.domain.survey.exception.QuestionNotFoundException;
import kr.pe.afterschool.domain.survey.presentation.dto.response.QuestionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SurveyQuestionQueryService {

    private final QuestionRepository questionRepository;
    private final ClassroomRepository classroomRepository;

    @Transactional(readOnly = true)
    public QuestionResponse execute(Long classroomId) {
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(() -> ClassroomNotFoundException.EXCEPTION);
        return new QuestionResponse(
                questionRepository.findByClassroom(classroom)
                .orElseThrow(() -> QuestionNotFoundException.EXCEPTION)
        );
    }
}
