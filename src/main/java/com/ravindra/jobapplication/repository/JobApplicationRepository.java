package com.ravindra.jobapplication.repository;

import com.ravindra.jobapplication.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository  extends JpaRepository<JobApplication,Long> {
}
