package kr.pe.afterschool.domain.survey.entity.repository;

import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.survey.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    Optional<Question> findByClassroom(Classroom classroom);
}
