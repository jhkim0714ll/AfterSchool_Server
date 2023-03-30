package kr.pe.afterschool.domain.apply.entity.repository;

import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.apply.entity.Apply;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.global.enums.ClassroomApplyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyRepository extends JpaRepository<Apply, Long> {

    List<Apply> findByClassroomAndStatus(Classroom classroom, ClassroomApplyStatus status);
    List<Apply> findByStudent(User student);
    List<Apply> findByClassroom(Classroom classroom);
}
