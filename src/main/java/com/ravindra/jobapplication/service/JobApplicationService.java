package com.ravindra.jobapplication.service;


import com.ravindra.jobapplication.entity.JobApplication;
import com.ravindra.jobapplication.repository.JobApplicationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public JobApplication getApplicationBYId(Long id){
        return jobApplicationRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Job Application not found with:"+id));
    }

    public JobApplication updateAplication(Long id,JobApplication updatedApplication){
        JobApplication existiedApplication=jobApplicationRepository.findById(id)
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,"job application is not Found with id:"+ id));

        existiedApplication.setCompanyName(updatedApplication.getCompanyName());

        existiedApplication.setJobTitle(updatedApplication.getJobTitle());

        existiedApplication.setStatus(updatedApplication.getStatus());

        existiedApplication.setAppliedDate(updatedApplication.getAppliedDate());

        return jobApplicationRepository.save(existiedApplication);

    }
}
