package kr.pe.afterschool.domain.classroom.service;

import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.classroom.entity.repository.ClassroomRepository;
import kr.pe.afterschool.domain.classroom.presentation.dto.request.ClassroomCreateRequest;
import kr.pe.afterschool.domain.user.entity.User;
import kr.pe.afterschool.domain.user.facade.UserFacade;
import kr.pe.afterschool.global.security.lib.DateParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ClassroomCreateService {

    private final ClassroomRepository classroomRepository;
    private final UserFacade userFacade;
    private final DateParser dateParser;

    @Transactional
    public void execute(ClassroomCreateRequest request) {
        User user = userFacade.getCurrentUser();
        Classroom classroom = Classroom.builder()
                .teacherName(request.getTeacherName())
                .name(request.getName())
                .week(DayOfWeek.valueOf(request.getWeek()))
                .startDate(dateParser.parseStringToDate(request.getStartDate()))
                .endDate(dateParser.parseStringToDate(request.getEndDate()))
                .school(user.getSchool())
                .peopleLimit(request.getPeopleLimit() == 0 ? 10000 : request.getPeopleLimit())
                .build();
        classroomRepository.save(classroom);
    }
}
