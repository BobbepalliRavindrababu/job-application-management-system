package com.ravindra.jobapplication.service;


import com.ravindra.jobapplication.entity.JobApplication;
import com.ravindra.jobapplication.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;

    public JobApplicationService(JobApplicationRepository jobApplicationRepository){
        this.jobApplicationRepository=jobApplicationRepository;
    }

    public JobApplication createProfile(JobApplication application){
        return jobApplicationRepository.save(application);
    }

    public List<JobApplication> getALlAopplications(){
        return jobApplicationRepository.findAll();
    }
}
