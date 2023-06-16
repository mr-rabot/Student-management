package com.hms.hospital_management.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import com.hms.hospital_management.models.Patients;
import com.hms.hospital_management.servicesimpl.PtService;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PatientController {

    
    public PtService service;

     public PatientController(PtService service){
        super();
        this.service = service;
    }

    @GetMapping(value="/")
    public String home() {
        return "index";
    }

    @GetMapping("/patient")
    public String listStudents(Model model){
      
        model.addAttribute("patient", service.getAllPatients());

        return "patient";
    }

    @GetMapping("/patient/add")
    public String createStudent(Model model){
        Patients patient = new Patients();
        model.addAttribute("patient", patient);
        return "ptreg";
    }

    @PostMapping("/patient")
	public String savePatient(@ModelAttribute("patient") Patients p) {
		service.savePatient(p);
		return "redirect:/patient";
	}

    @GetMapping("/patient/edit/{id}")
	public String editPatientForm(@PathVariable Integer id, Model model) {
        model.addAttribute("patient", service.getPatientById(id));
		return "update_pt";
	}
    
    @PostMapping("/patient/{id}")
	public String updateStudent(@PathVariable Integer id,
			@ModelAttribute("patient") Patients patient,
			Model model) {
		
		Patients exPatients = service.getPatientById(id);
		exPatients.setId(id);
	    exPatients.setPtname(patient.getPtname());
		exPatients.setPtage(patient.getPtage());
        exPatients.setTreatments(patient.getTreatments());
		
		service.updatePatients(exPatients);
		return "redirect:/patient";		
	}

    @GetMapping("/patient/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		service.deletePatientById(id);
		return "redirect:/patient";
	}	
    
}
