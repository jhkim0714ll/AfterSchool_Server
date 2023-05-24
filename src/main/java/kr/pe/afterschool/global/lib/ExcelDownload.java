package kr.pe.afterschool.global.lib;

import kr.pe.afterschool.global.error.exception.InternalServerException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class ExcelDownload {

    private final HttpServletResponse response;

    public void outStream(Workbook workbook, String fileName) {
        try {
            String outputFileName = new String(fileName.getBytes("KSC5601"), "8859_1");
            response.setHeader("Content-Disposition", "attachment; fileName=\"" + outputFileName + "\"");

            workbook.write(response.getOutputStream());
            workbook.close();
        } catch (Exception e) {
            throw InternalServerException.EXCEPTION;
        }
    }

    public Workbook createWorkbook() {
        return new XSSFWorkbook();
    }

    public Sheet createSheet(Workbook workbook, String sheetName, int columnIndex) {
        Sheet sheet =  workbook.createSheet(sheetName);
        for (int i = 0; i < columnIndex; i++) {
            sheet.setColumnWidth(i, (short) 6000);
        }
        return sheet;
    }

    public void createCell(Row row, List<Object> stringList) {
        Cell cell;
        int cellNum = 0;

        for (Object string : stringList) {
            cell = row.createCell(cellNum++);
            if (string instanceof Integer) {
                cell.setCellValue(Integer.parseInt(string.toString()));
            } else if (string instanceof Long) {
                cell.setCellValue(Long.parseLong(string.toString()));
            } else {
                cell.setCellValue(string.toString());
            }
        }
    }
}
