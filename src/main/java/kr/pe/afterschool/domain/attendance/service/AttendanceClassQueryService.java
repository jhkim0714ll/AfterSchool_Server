package kr.pe.afterschool.domain.attendance.service;

import kr.pe.afterschool.domain.attendance.entity.Attendance;
import kr.pe.afterschool.domain.attendance.entity.repository.AttendanceRepository;
import kr.pe.afterschool.domain.attendance.presentation.dto.response.AttendanceResponse;
import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.classroom.entity.repository.ClassroomRepository;
import kr.pe.afterschool.domain.classroom.exception.ClassroomNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttendanceClassQueryService {

    private final AttendanceRepository attendanceRepository;
    private final ClassroomRepository classroomRepository;

    @Transactional(readOnly = true)
    public List<AttendanceResponse> execute(Long classroomId) {
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(() -> ClassroomNotFoundException.EXCEPTION);
        return attendanceRepository.findByClassroom(classroom)
                .stream().map(AttendanceResponse::new).collect(Collectors.toList());
    }
}
