package com.ravindra.jobapplication.dto;

import com.ravindra.jobapplication.entity.ApplicationStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class JobApplicationRequestDTO {

    @NotBlank(message="Company Name is required")
    @Size(max=100,message="company name must not exceed 100 characters")
    private String companyName;

    @NotBlank(message="Job title is required")
    @Size(max=150,message="Job Title must not exceed 100 characters")
    private String jobTitle;

    @NotNull(message="Application status is required")
    private ApplicationStatus status;

    @NotNull(message="Applied Date is required")
    private LocalDate appliedDate;
}
