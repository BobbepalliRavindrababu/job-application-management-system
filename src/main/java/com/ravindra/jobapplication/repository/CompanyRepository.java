package com.ravindra.jobapplication.repository;

import com.ravindra.jobapplication.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
