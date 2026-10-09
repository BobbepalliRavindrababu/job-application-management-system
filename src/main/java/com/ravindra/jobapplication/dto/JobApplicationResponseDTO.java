package com.ravindra.jobapplication.dto;

import com.ravindra.jobapplication.entity.ApplicationStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class JobApplicationResponseDTO {
    private Long id;
    private String CompanyName;
    private String jobTitle;
    private ApplicationStatus status;
    private LocalDate appliedDate;
}
