package com.hms.hospital_management.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Patients {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    public String ptname;
    public int ptage;
    public String treatments;
    
}
