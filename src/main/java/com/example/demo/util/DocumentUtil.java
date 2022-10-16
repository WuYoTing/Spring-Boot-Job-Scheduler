package com.example.demo.util;

import com.example.demo.entity.Job;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.domain.Page;

public class DocumentUtil {

  public ByteArrayInputStream generateExcel(String sheetName, List<String> headers,
      Page<Job> jobs) {
    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
      // Sheet Name
      Sheet sheet = workbook.createSheet(sheetName);
      // Header
      Row headerRow = sheet.createRow(0);
      for (int col = 0; col < headers.size(); col++) {
        Cell cell = headerRow.createCell(col);
        cell.setCellValue(headers.get(col));
      }
      // Body
      int rowIdx = 1;
      for (Job job : jobs) {
        Row row = sheet.createRow(rowIdx++);

        row.createCell(0).setCellValue(job.getJobStatus() != null ? job.getJobStatus().toString() : "");
        row.createCell(1).setCellValue(job.getActualJobExecutionTime() != null ? job.getActualJobExecutionTime().toString() : "");
        row.createCell(2).setCellValue(job.getJobType() != null ? job.getJobType().toString() : "");
        row.createCell(3).setCellValue(job.getCreatedDate() != null ? job.getCreatedDate().toString() : "");
      }

      workbook.write(out);
      return new ByteArrayInputStream(out.toByteArray());
    } catch (IOException e) {
      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
    }
  }
}
