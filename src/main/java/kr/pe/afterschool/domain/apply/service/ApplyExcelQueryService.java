package kr.pe.afterschool.domain.apply.service;

import kr.pe.afterschool.domain.apply.entity.Apply;
import kr.pe.afterschool.domain.apply.entity.repository.ApplyRepository;
import kr.pe.afterschool.domain.classroom.entity.Classroom;
import kr.pe.afterschool.domain.classroom.entity.repository.ClassroomRepository;
import kr.pe.afterschool.domain.school.entity.School;
import kr.pe.afterschool.domain.school.entity.repository.SchoolRepository;
import kr.pe.afterschool.domain.school.exception.SchoolNotFoundException;
import kr.pe.afterschool.global.enums.ApplyStatus;
import kr.pe.afterschool.global.lib.DateParser;
import kr.pe.afterschool.global.lib.ExcelDownload;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplyExcelQueryService {

    private final SchoolRepository schoolRepository;
    private final ClassroomRepository classroomRepository;
    private final ApplyRepository applyRepository;
    private final ExcelDownload excelDownload;
    private final DateParser dateParser;

    @Transactional(readOnly = true)
    public void execute(Long schoolId) {
        Row row;
        int sheetRowNum = 0;
        int classroomSheetRowNum;
        Workbook workbook = excelDownload.createWorkbook();

        //전체 방과후 시트
        Sheet sheet = excelDownload.createSheet(workbook, "전체 방과후 내역", 5);
        List<Object> sheetTitle = new ArrayList<>(Arrays.asList("고유 번호", "방과후 이름", "담당 선생님", "요일", "신청인원"));

        row = sheet.createRow(sheetRowNum++);
        excelDownload.createCell(row, sheetTitle); //첫 시트의 제목 셀을 만듬

        School school = schoolRepository.findById(schoolId)
                    .orElseThrow(() -> SchoolNotFoundException.EXCEPTION);

        List<Classroom> classroomList = classroomRepository.findBySchool(school);
        for (Classroom classroom : classroomList) {
            List<Apply> applyList = applyRepository.findByClassroomAndStatus(classroom, ApplyStatus.ALLOWED);
            List<Object> contentOfClassroomList = new ArrayList<>(Arrays.asList(
                    classroom.getId(),
                    classroom.getName(),
                    classroom.getTeacherName(),
                    dateParser.parseWeekToKoreanWeek(classroom.getWeek()),
                    applyList.size()));

            row = sheet.createRow(sheetRowNum++);
            excelDownload.createCell(row, contentOfClassroomList); //첫 시트의 모든 방과후 셀을 만듬

            //방과후 신청자 시트
            classroomSheetRowNum = 0;
            Sheet classroomSheet = excelDownload.createSheet(workbook, classroom.getName() + " 방과후 신청자 내역", 5);
            List<Object> classroomSheetTitle = new ArrayList<>(Arrays.asList("고유 번호", "학년", "반", "번호", "이름"));

            row = classroomSheet.createRow(classroomSheetRowNum++);

            excelDownload.createCell(row, classroomSheetTitle); //방과후 신청자 시트의 제목 셀을 만듬
            for (Apply apply : applyList) {
                List<Object> contentOfApplierList = new ArrayList<>(Arrays.asList(
                        apply.getId(),
                        apply.getStudent().getGrade(),
                        apply.getStudent().getRoom(),
                        apply.getStudent().getNumber(),
                        apply.getStudent().getName()));
                row = classroomSheet.createRow(classroomSheetRowNum++);
                excelDownload.createCell(row, contentOfApplierList); //방과후 신청자 시트의 모든 신청자 셀을 만듬
            }
            List<Object> applyListCell = new ArrayList<>(Arrays.asList(
                    "총 인원" ,
                    applyList.size()));
            row = classroomSheet.createRow(classroomSheetRowNum);
            excelDownload.createCell(row, applyListCell);
        }
        excelDownload.outStream(workbook, school.getName() + "학교 방과후 신청자 리스트.xlsx");
    }
}
