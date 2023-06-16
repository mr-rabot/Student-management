package com.hms.hospital_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hms.hospital_management.models.Patients;

public interface PtRepo extends JpaRepository<Patients , Integer>{
    
}
