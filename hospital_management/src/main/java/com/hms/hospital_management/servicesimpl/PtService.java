package com.hms.hospital_management.servicesimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hms.hospital_management.models.Patients;

@Service
public interface PtService {

     List<Patients> getAllPatients();  

    Patients savePatient(Patients patient);
	
	Patients getPatientById(Integer id);
	
	Patients updatePatients(Patients patient);
	
	void deletePatientById(Integer id);
}

