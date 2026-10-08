package com.ravindra.jobapplication.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String jobTitle;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;
    private LocalDate appliedDate;
}
