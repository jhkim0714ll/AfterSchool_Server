package kr.pe.afterschool.domain.classroom.entity.repository;

import kr.pe.afterschool.domain.classroom.entity.ClassroomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomUserRepository extends JpaRepository<ClassroomUser, Long> {
}
