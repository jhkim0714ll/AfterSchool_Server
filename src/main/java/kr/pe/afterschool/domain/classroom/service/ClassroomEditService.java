package kr.pe.afterschool.domain.classroom.service;

import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.classroom.entity.repository.ClassroomRepository;
import kr.pe.afterschool.domain.classroom.exception.ClassroomCannotManageException;
import kr.pe.afterschool.domain.classroom.exception.ClassroomNotFoundException;
import kr.pe.afterschool.domain.classroom.presentation.dto.request.ClassroomEditRequest;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import kr.pe.afterschool.global.enums.UserRole;
import kr.pe.afterschool.global.security.lib.DateParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;

@Service
@RequiredArgsConstructor
public class ClassroomEditService {

    private final ClassroomRepository classroomRepository;
    private final UserFacade userFacade;
    private final DateParser dateParser;

    @Transactional
    public void execute(Long classroomId, ClassroomEditRequest request) {
        User user = userFacade.getCurrentUser();
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(() -> ClassroomNotFoundException.EXCEPTION);
        if (user.getSchool() != classroom.getSchool()) {
            throw ClassroomCannotManageException.EXCEPTION;
        }
        classroom.editClassroomData(
                request.getTeacherName() == null ? classroom.getTeacherName() : request.getTeacherName(),
                request.getName() == null ? classroom.getName() : request.getName(),
                request.getWeek() == null ? classroom.getWeek() : DayOfWeek.valueOf(request.getWeek()),
                request.getStartDate() == null ? classroom.getStartDate() : dateParser.parseStringToDate(request.getStartDate()),
                request.getEndDate() == null ? classroom.getEndDate() :dateParser.parseStringToDate(request.getEndDate()),
                request.getPeopleLimit() == 0 ? classroom.getPeopleLimit() : request.getPeopleLimit());
        classroomRepository.save(classroom);
    }
}
