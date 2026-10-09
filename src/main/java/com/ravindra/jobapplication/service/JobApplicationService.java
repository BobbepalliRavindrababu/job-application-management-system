package com.ravindra.jobapplication.service;


import com.ravindra.jobapplication.dto.JobApplicationResponseDTO;
import com.ravindra.jobapplication.dto.JobApplicationRequestDTO;
import com.ravindra.jobapplication.entity.JobApplication;
import com.ravindra.jobapplication.mapper.JobApplicationMapper;
import com.ravindra.jobapplication.repository.JobApplicationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final JobApplicationMapper jobApplicationMapper;

    public JobApplicationService(JobApplicationRepository jobApplicationRepository, JobApplicationMapper jobApplicationMapper){
        this.jobApplicationRepository=jobApplicationRepository;
        this.jobApplicationMapper=jobApplicationMapper;
    }

    public JobApplicationResponseDTO createProfile(JobApplicationRequestDTO request){
        JobApplication application=jobApplicationMapper.toEntity(request);
        JobApplication savedApplication= jobApplicationRepository.save(application);
        return jobApplicationMapper.toResponseDTO(savedApplication);
    }

    public List<JobApplicationResponseDTO> getALlApplications(){
        return jobApplicationRepository.findAll()
                .stream()
                .map(jobApplicationMapper::toResponseDTO)
                .toList();
    }

    public JobApplicationResponseDTO getApplicationBYId(Long id){
        JobApplication application= jobApplicationRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Job Application not found with:"+id));

        return jobApplicationMapper.toResponseDTO(application);
    }

    public JobApplicationResponseDTO updateAplication(Long id,JobApplicationRequestDTO requestDTO){
        JobApplication existiedApplication=jobApplicationRepository.findById(id)
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,"job application is not Found with id:"+ id));

        jobApplicationMapper.updateEntity(requestDTO,existiedApplication);

        JobApplication application=jobApplicationRepository.save(existiedApplication);

        return jobApplicationMapper.toResponseDTO(existiedApplication);

    }

    public void deleteApplication(Long id){
        JobApplication application=jobApplicationRepository.findById(id)
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,"job application with this id:" + id));

        jobApplicationRepository.delete(application);
    }
}
