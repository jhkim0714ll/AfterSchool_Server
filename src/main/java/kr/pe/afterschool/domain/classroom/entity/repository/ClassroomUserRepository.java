package kr.pe.afterschool.domain.classroom.entity.repository;

import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.classroom.entity.ClassroomUser;
import kr.pe.afterschool.global.enums.ClassroomUserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomUserRepository extends JpaRepository<ClassroomUser, Long> {

    List<ClassroomUser> findByClassroomAndStatus(Classroom classroom, ClassroomUserStatus status);
}
