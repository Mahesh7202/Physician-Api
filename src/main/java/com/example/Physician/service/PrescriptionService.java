package com.example.Physician.service;

import com.example.Physician.model.Patient;
import com.example.Physician.model.Prescription;

import java.util.List;

public interface PrescriptionService {


    Prescription savePrescription(Prescription prescription);

    List<Prescription> getPrescription();

    Prescription getPrescriptionById(long pre_id);

    Prescription deletePrescription(long pre_id);

    Prescription updatePrescription(long pre_id,Prescription prescription);
}
