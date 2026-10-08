package com.ravindra.jobapplication.controller;

import com.ravindra.jobapplication.entity.JobApplication;
import com.ravindra.jobapplication.service.JobApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class JobApplicationController {
    private final JobApplicationService jobApplicationService;

    public JobApplicationController(JobApplicationService jobApplicationService){
        this.jobApplicationService=jobApplicationService;
    }

    @PostMapping
    public ResponseEntity<JobApplication> createApplication(@RequestBody JobApplication jobApplication){
        JobApplication application=jobApplicationService.createProfile(jobApplication);

        return ResponseEntity.status(HttpStatus.CREATED).body(application);
    }

    @GetMapping
    public ResponseEntity<List<JobApplication>> getAllApplications(){
        List<JobApplication> applications=jobApplicationService.getALlAopplications();

        return ResponseEntity.ok(applications);

    }
}
