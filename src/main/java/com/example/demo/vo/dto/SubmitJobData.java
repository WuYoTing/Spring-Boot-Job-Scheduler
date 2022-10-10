package com.example.demo.vo.dto;

import com.example.demo.vo.share.JobType;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmitJobData {

  private UUID userId;
  private JobType jobType;
  private int priority;
}
