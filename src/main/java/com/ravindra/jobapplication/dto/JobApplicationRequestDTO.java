package com.ravindra.jobapplication.dto;

import com.ravindra.jobapplication.entity.ApplicationStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class JobApplicationRequestDTO {
    private String companyName;
    private String jobTitle;
    private ApplicationStatus status;
    private LocalDate appliedDate;
}
