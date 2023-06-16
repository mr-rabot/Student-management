package com.hms.hospital_management.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hms.hospital_management.models.Patients;
import com.hms.hospital_management.repositories.PtRepo;
import com.hms.hospital_management.servicesimpl.PtService;


@Service
public class PtServiceimpl implements PtService{

   
    public PtRepo prepo;

     public PtServiceimpl(PtRepo prepo){

        super();

        this.prepo = prepo;


    }

    @Override
    public Patients savePatient(Patients p){
        return prepo.save(p);
    }

    @Override
    public void deletePatientById(Integer id){
         prepo.deleteById(id);
    }

    @Override
    public List<Patients> getAllPatients(){
        return (List<Patients>) prepo.findAll();
    }

    @Override
    public Patients getPatientById(Integer id) {
        return prepo.findById(id).get();
    }

    @Override
    public Patients updatePatients(Patients patient) {
        return prepo.save(patient);
    }    
    
}
