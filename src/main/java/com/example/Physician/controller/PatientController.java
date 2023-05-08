package com.example.Physician.controller;


import com.example.Physician.model.Patient;
import com.example.Physician.model.Prescription;
import com.example.Physician.service.PatientService;
import com.example.Physician.service.impl.PatientServiceImp;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientServiceImp patientServiceImp;

    @Autowired
    public PatientController(PatientServiceImp patientServiceImp) {
        this.patientServiceImp = patientServiceImp;
    }

    @PostMapping
    public ResponseEntity<Patient> savePatient(@RequestBody final Patient patient){
        Patient patient_save = patientServiceImp.savePatient(patient);
        return new ResponseEntity<>(patient_save, HttpStatus.OK);
    }

    @PostMapping("/prescription")
    public ResponseEntity<Patient> savePatientWithPrescription(@RequestBody final Patient patient){
        Patient patient1 = patientServiceImp.savePatientWithPrescription(patient);
        return new ResponseEntity<>(patient1, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getPatients(){
        List<Patient> patients = patientServiceImp.getPatient();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping(value = "/{patient_id}")
    public ResponseEntity<Patient> getPatient(@PathVariable final Long patient_id){
        Patient patient = patientServiceImp.getPatientById(patient_id);
        return new ResponseEntity<>(patient,HttpStatus.OK);
    }


    @PutMapping(value = "/{patient_id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable final Long patient_id,
                                                              @RequestBody final Patient patientDto){
        Patient patient_edit = patientServiceImp.updatePatient(patient_id,
                patientDto);
        return new ResponseEntity<>(patient_edit,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{patient_id}")
    public ResponseEntity<Patient> deletePatient(@PathVariable final Long patient_id){
        Patient patient = patientServiceImp.deletePatient(patient_id);
        return new ResponseEntity<>(patient,HttpStatus.OK);
    }



    @PostMapping(value = "/{patient_id}/prescription/{prescription_id}")
    public ResponseEntity<Patient> savePrescriptionToPatient(@PathVariable final Long patient_id,
                                                                @PathVariable final Long prescription_id){

        Patient patient = patientServiceImp.savePrescriptionToPatient(patient_id, prescription_id);
        return new ResponseEntity<>(patient,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{patient_id}/prescription/{prescription_id}")
    public ResponseEntity<Patient> deletePrescriptionToPatient(@PathVariable final Long patient_id,
                                                                @PathVariable final Long prescription_id){

        Patient patient = patientServiceImp.deletePrescriptionFromPatient(patient_id, prescription_id);
        return new ResponseEntity<>(patient,HttpStatus.OK);
    }

    @GetMapping(value = "/{patient_id}/prescription/{prescription_id}")
    public ResponseEntity<Patient> getPrescriptionFromPatient(@PathVariable final Long patient_id,
                                                                  @PathVariable final Long prescription_id){

        Patient patient = patientServiceImp.getPrescriptionFromPatient(patient_id, prescription_id);
        return new ResponseEntity<>(patient,HttpStatus.OK);
    }



}
