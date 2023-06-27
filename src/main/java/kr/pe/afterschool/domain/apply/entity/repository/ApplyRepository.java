package kr.pe.afterschool.domain.apply.entity.repository;

import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.apply.entity.Apply;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.global.enums.ApplyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplyRepository extends JpaRepository<Apply, Long> {

    List<Apply> findByClassroomAndStatus(Classroom classroom, ApplyStatus status);
    List<Apply> findByStudent(User student);
    List<Apply> findByClassroom(Classroom classroom);
    boolean existsByClassroomAndStudent(Classroom classroom, User student);
}
