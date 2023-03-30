package kr.pe.afterschool.domain.classroom.entity.repository;

import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.classroom.entity.ClassroomApply;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.global.enums.ClassroomApplyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomApplyRepository extends JpaRepository<ClassroomApply, Long> {

    List<ClassroomApply> findByClassroomAndStatus(Classroom classroom, ClassroomApplyStatus status);
    List<ClassroomApply> findByStudent(User student);
    List<ClassroomApply> findByClassroom(Classroom classroom);
}
