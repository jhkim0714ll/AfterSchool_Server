package kr.pe.afterschool.domain.survey.service;

import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.classroom.entity.repository.ClassroomRepository;
import kr.pe.afterschool.domain.classroom.exception.ClassroomNotFoundException;
import kr.pe.afterschool.domain.school.entity.School;
import kr.pe.afterschool.domain.school.entity.repository.SchoolRepository;
import kr.pe.afterschool.domain.school.exception.SchoolNotFoundException;
import kr.pe.afterschool.domain.survey.entity.Answer;
import kr.pe.afterschool.domain.survey.entity.repository.AnswerRepository;
import kr.pe.afterschool.domain.survey.exception.SurveyNotFoundException;
import kr.pe.afterschool.global.lib.DateParser;
import kr.pe.afterschool.global.lib.ExcelDownload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SurveyAnswerExcelQueryService {

    private final AnswerRepository answerRepository;
    private final SchoolRepository schoolRepository;
    private final ClassroomRepository classroomRepository;
    private final ExcelDownload excelDownload;
    private final DateParser dateParser;

    @Transactional(readOnly = true)
    public void execute(Long schoolId, Long classroomId) {
        Row row;
        int sheetRowNum = 0;
        int schoolSheetRowNum = 0;
        Workbook workbook = excelDownload.createWorkbook();

        if (schoolId != null) {
            School school = schoolRepository.findById(schoolId)
                    .orElseThrow(() -> SchoolNotFoundException.EXCEPTION);

            Sheet sheet = excelDownload.createSheet(workbook, "전체 방과후 내역", 4);
            List<Object> sheetTitle = new ArrayList<>(Arrays.asList("고유 번호", "방과후 이름", "담당 선생님", "요일"));

            row = sheet.createRow(sheetRowNum++);
            excelDownload.createCell(row, sheetTitle);

            List<Classroom> classroomList = classroomRepository.findBySchool(school);
            for (Classroom classroom : classroomList) {
                List<Object> contentOfClassroomList = new ArrayList<>(Arrays.asList(
                        classroom.getId(),
                        classroom.getName(),
                        classroom.getTeacherName(),
                        dateParser.parseWeekToKoreanWeek(classroom.getWeek())));

                row = sheet.createRow(sheetRowNum++);
                excelDownload.createCell(row, contentOfClassroomList);

                createSurveySheet(schoolSheetRowNum, workbook, classroom);
            }
            excelDownload.outStream(workbook, school.getName() + " 방과후 설문조사 결과.xlsx");
        } else if (classroomId != null) {
            Classroom classroom = classroomRepository.findById(classroomId)
                    .orElseThrow(() -> ClassroomNotFoundException.EXCEPTION);

            createSurveySheet(schoolSheetRowNum, workbook, classroom);
            excelDownload.outStream(workbook, classroom.getName() + " 방과후 설문조사 결과.xlsx");
        } else {
            throw SurveyNotFoundException.EXCEPTION;
        }
    }

    private void createSurveySheet(int schoolSheetRowNum, Workbook workbook, Classroom classroom) {
        Row row;
        Sheet classroomSheet = excelDownload.createSheet(workbook, classroom.getName() + " 방광후 설문 조사 결과", 9);
        List<Object> classroomSheetTitle = new ArrayList<>(Arrays.asList("학년", "반", "번호", "이름", "방과후에 노력한 정도(1~5)", "방과후에 대한 학습 기여도(1~5)", "강사의 기술 및 대응능력(1~5)", "강의 내용 난이도(1~5)", "방과후 개선 방안"));

        row = classroomSheet.createRow(schoolSheetRowNum++);

        excelDownload.createCell(row, classroomSheetTitle);
        List<Answer> answerList = answerRepository.findByClassroom(classroom);
        for (Answer answer : answerList) {
            String[] surveyContent = answer.getAnswer().split("::");
            List<Object> surveyListCell = new ArrayList<>(Arrays.asList(
                    answer.getStudent().getGrade(),
                    answer.getStudent().getRoom(),
                    answer.getStudent().getNumber(),
                    answer.getStudent().getName(),
                    surveyContent[0],
                    surveyContent[1],
                    surveyContent[2],
                    surveyContent[3],
                    surveyContent[4],
                    surveyContent[5]));
            row = classroomSheet.createRow(schoolSheetRowNum++);
            excelDownload.createCell(row, surveyListCell);
        }
    }
}
