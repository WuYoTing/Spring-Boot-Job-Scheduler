package com.example.demo.service;

import com.example.demo.entity.Job;
import com.example.demo.repository.JobRepository;
import com.example.demo.vo.share.JobType;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@AllArgsConstructor
public class JobService {

  private final JobRepository jobRepository;

  public String submitJob(UUID userId, Date now, JobType jobType, int priority) {
    Job job = new Job(userId, now, jobType);
    job = jobRepository.save(job);
    return job.getJobId();
  }
}
