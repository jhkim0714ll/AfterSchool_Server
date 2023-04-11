package kr.pe.afterschool.global.lib;

import kr.pe.afterschool.global.error.exception.InternalServerException;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    public Sheet createSheet(Workbook workbook, String sheetName) {
        Sheet sheet =  workbook.createSheet(sheetName);
        sheet.setColumnWidth(0, (short) 6000);
        sheet.setColumnWidth(1, (short) 6000);
        sheet.setColumnWidth(2, (short) 6000);
        sheet.setColumnWidth(3, (short) 6000);
        sheet.setColumnWidth(4, (short) 6000);
        return sheet;
    }

    public void createCell(Row row, List<Object> stringList) {
        Cell cell = null;
        int cellNum = 0;

        for (Object string : stringList) {
            cell = row.createCell(cellNum++);
            cell.setCellValue(string.toString());
        }
    }
}
