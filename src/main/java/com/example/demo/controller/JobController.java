package com.example.demo.controller;

import com.example.demo.service.JobService;
import com.example.demo.vo.dto.SubmitJobData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("job")
@AllArgsConstructor
@Tag(name = "Job API", description = "Job API")
public class JobController {

  private final JobService jobService;

  @Operation(summary = "View Jobs", description = "View Jobs")
  @GetMapping("view")
  public ResponseEntity<?> viewJob() {
    // viewJob(user_id, job_id)
    return new ResponseEntity<>(HttpStatus.OK);
  }


  @Operation(summary = "Submit Job", description = "Submit Job")
  @PutMapping("submit")
  public ResponseEntity submitJob(@RequestBody SubmitJobData submitJobData) {
    Date now = new Date();
    String jobUuid = jobService.submitJob(submitJobData.getUserId(), now, submitJobData.getJobType(),
        submitJobData.getPriority());
    return new ResponseEntity<>(jobUuid, HttpStatus.OK);
  }


  @Operation(summary = "List Job", description = "List Job")
  @GetMapping("list")
  public ResponseEntity listob() {
    // listJobs(user_id, pagination_token)
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
