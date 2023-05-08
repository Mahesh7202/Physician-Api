package com.example.Physician.service.impl;

import com.example.Physician.exception.PatientNotFoundException;
import com.example.Physician.model.Patient;
import com.example.Physician.model.Prescription;
import com.example.Physician.repository.PatientRepository;
import com.example.Physician.service.PatientService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImp implements PatientService {

    private PatientRepository patientRepository;
    private PrescriptionServiceImpl prescriptionServiceimpl;


    public PatientServiceImp(PatientRepository patientRepository, PrescriptionServiceImpl prescriptionServiceimpl) {
        this.patientRepository = patientRepository;
        this.prescriptionServiceimpl = prescriptionServiceimpl;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient savePatientWithPrescription(Patient patient) {
        Patient patients = savePatient(patient);
        List<Prescription> prescriptions = patient.getPrescriptions();
        prescriptions.stream().forEach((prescription)->prescriptionServiceimpl.savePrescription(prescription));

     return patients;
    }

    @Override
    public List<Patient> getPatient() {

        return patientRepository.findAll();
    }



    @Override
    public Patient getPatientById(long p_id) {
        return patientRepository.findById(p_id).orElseThrow(
                ()-> new PatientNotFoundException(p_id)
        );
    }

    @Override
    public Patient deletePatient(long p_id){
        Patient patient = getPatientById(p_id);
        patientRepository.delete(patient);
        return patient;
    }

    @Override
    @Transactional
    public Patient updatePatient(long p_id,Patient patient){
        Patient patient_edit = getPatientById(p_id);
        patient_edit.setFirstname(patient.getFirstname());
        patient_edit.setLastname(patient.getLastname());

        return patient_edit;
    }

    @Override
    @Transactional
    public Patient savePrescriptionToPatient(long p_id, long pre_id) {
        Patient patient = getPatientById(p_id);
        Prescription prescription = prescriptionServiceimpl.getPrescriptionById(pre_id);
        patient.savePrescription(prescription);
        return patient;
    }

    ///weeeeeeeeeeseeeeeeeeeeeeeeeeee
    @Override
    public Patient getPrescriptionFromPatient(long p_id, long pre_id) {
        Patient patient = getPatientById(p_id);
        Prescription prescription = prescriptionServiceimpl.getPrescriptionById(pre_id);
        patient.getPrescriptions();
        return patient;
    }


    @Override
    @Transactional
    public Patient deletePrescriptionFromPatient(long p_id, long pre_id){
        Patient patient = getPatientById(p_id);
        Prescription prescription = prescriptionServiceimpl.getPrescriptionById(pre_id);
        patient.deletePrescription(prescription);
        return patient;
    }
}
