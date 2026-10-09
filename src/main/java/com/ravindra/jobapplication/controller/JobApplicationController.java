package com.ravindra.jobapplication.controller;

import com.ravindra.jobapplication.dto.JobApplicationRequestDTO;
import com.ravindra.jobapplication.dto.JobApplicationResponseDTO;
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
    public ResponseEntity<JobApplicationResponseDTO> createApplication(@RequestBody JobApplicationRequestDTO request){
        JobApplicationResponseDTO responseDTO =jobApplicationService.createProfile(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<JobApplicationResponseDTO>> getAllApplications(){
        List<JobApplicationResponseDTO> applications=jobApplicationService.getALlApplications();

        return ResponseEntity.ok(applications);

    }

    @GetMapping("/{id}")
    public ResponseEntity<JobApplicationResponseDTO> getApplicationById(@PathVariable Long id){
        JobApplicationResponseDTO application=jobApplicationService.getApplicationBYId(id);

        return ResponseEntity.ok(application);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobApplicationResponseDTO> updateApplication(@PathVariable Long id, @RequestBody JobApplicationRequestDTO requestDTO){
        JobApplicationResponseDTO updatedApplication=jobApplicationService.updateAplication(id,requestDTO);

        return ResponseEntity.ok(updatedApplication);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id){
        jobApplicationService.deleteApplication(id);

        return ResponseEntity.noContent().build();
    }
}
