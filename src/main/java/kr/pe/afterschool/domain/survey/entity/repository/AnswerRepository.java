package kr.pe.afterschool.domain.survey.entity.repository;

import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.survey.entity.Answer;
import kr.pe.afterschool.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    List<Answer> findByClassroom(Classroom classroom);
    List<Answer> findByStudent(User student);
}
