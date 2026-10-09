package com.ravindra.jobapplication.mapper;


import com.ravindra.jobapplication.dto.JobApplicationRequestDTO;
import com.ravindra.jobapplication.dto.JobApplicationResponseDTO;
import com.ravindra.jobapplication.entity.JobApplication;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public interface JobApplicationMapper {

    JobApplication toEntity(JobApplicationRequestDTO requestDTO);

    JobApplicationResponseDTO toResponseDTO(JobApplication jobApplication);

    void updateEntity(JobApplicationRequestDTO requestDTO, @MappingTarget JobApplication application);

}
