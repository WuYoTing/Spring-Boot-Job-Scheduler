package com.example.demo.vo.dto;

import com.example.demo.vo.share.JobType;
import java.util.UUID;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmitJobData {


  @NotBlank
  private UUID userId;
  private JobType jobType;
  @Min(0)
  private int priority;
}
