package kr.pe.afterschool.domain.attendance.entity.repository;

import kr.pe.afterschool.domain.attendance.entity.Attendance;
import kr.pe.afterschool.domain.classroom.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByClassroom(Classroom classroom);
}
