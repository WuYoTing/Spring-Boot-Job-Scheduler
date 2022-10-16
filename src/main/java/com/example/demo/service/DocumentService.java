package com.example.demo.service;

import com.example.demo.entity.Job;
import com.example.demo.repository.JobRepository;
import com.example.demo.util.DocumentUtil;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@AllArgsConstructor
public class DocumentService {

  private final String JOB_REPORT_SHEET_NAME = "Job";

  private final JobRepository jobRepository;

  public ByteArrayInputStream generateJobReport(@Max(100) int param) {
    Page<Job> jobs = jobRepository.findAll(
        PageRequest.of(0, param, Sort.by(Sort.Order.desc("createdDate"))));

    // Get Entity Column Name
    List<String> columnNames = new ArrayList<>();
    for (Field field : Job.class.getDeclaredFields()) {
      Column column = field.getAnnotation(Column.class);
      if (column != null) {
        columnNames.add(column.name());
      }
    }

    ByteArrayInputStream byteArrayInputStream = new DocumentUtil().generateExcel(JOB_REPORT_SHEET_NAME,
        columnNames,jobs);

    return byteArrayInputStream;
  }
}
