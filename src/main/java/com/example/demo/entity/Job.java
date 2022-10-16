package com.example.demo.entity;

import com.example.demo.vo.share.JobStatus;
import com.example.demo.vo.share.JobType;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "job")
@NoArgsConstructor
@AllArgsConstructor
public class Job {

  @Id
  @Column(name = "user_id")
  private String userId;

  @Column(name = "job_id")
  private String jobId;

  @Column(name = "actual_job_execution_time")
  private Date actualJobExecutionTime;

  @Enumerated(EnumType.STRING)
  @Column(name = "job_status")
  private JobStatus jobStatus;

  @Enumerated(EnumType.STRING)
  @Column(name = "job_type")
  private JobType jobType;

  @Column(name = "job_interval")
  private Integer jobInterval;

  @Column(name = "result_location")
  private String resultLocation;

  @Column(name = "current_retries")
  private Integer currentRetries;

  @Column(name = "max_retries")
  private Integer maxRetries;

  @Column(name = "scheduled_job_execution_time")
  private Date scheduledJobExecutionTime;

  @Column(name = "execution_status")
  private String executionStatus;

  @Column(name = "created_date")
  private Date createdDate;

  public Job(UUID userId, Date now, JobType jobType) {
    this.userId = String.valueOf(userId);
    this.jobId = String.valueOf(UUID.randomUUID());
    this.scheduledJobExecutionTime = now;
    this.jobType = jobType;
    this.createdDate = now;
  }
}
