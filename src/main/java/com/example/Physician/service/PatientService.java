package com.example.Physician.service;

import com.example.Physician.model.Patient;

import java.util.List;

public interface PatientService {

    Patient savePatient(Patient patient);

    Patient savePatientWithPrescription(Patient patient);

    List<Patient> getPatient();

    Patient getPatientById(long p_id);

    Patient deletePatient(long p_id);

    Patient updatePatient(long p_id,Patient patient);

    Patient savePrescriptionToPatient(long p_id,long pre_id);

    Patient getPrescriptionFromPatient(long p_id,long pre_id);

    Patient deletePrescriptionFromPatient(long p_id,long pre_id);
}
