package kr.pe.afterschool.domain.survey.entity.repository;

import kr.pe.afterschool.domain.survey.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
