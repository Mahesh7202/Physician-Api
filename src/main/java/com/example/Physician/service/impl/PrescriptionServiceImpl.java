package com.example.Physician.service.impl;

import com.example.Physician.exception.PrescriptionNotFoundException;
import com.example.Physician.model.Patient;
import com.example.Physician.model.Prescription;
import com.example.Physician.repository.PrescriptionRepository;
import com.example.Physician.service.PrescriptionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    private PrescriptionRepository prescriptionRepository;


    @Autowired
    public PrescriptionServiceImpl(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }


    @Override
    public Prescription savePrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    @Override
    public List<Prescription> getPrescription() {
        return prescriptionRepository.findAll();
    }

    @Override
    public Prescription getPrescriptionById(long pre_id) {
        return prescriptionRepository.findById(pre_id).orElseThrow(
                ()->new PrescriptionNotFoundException(pre_id)
        );
    }

    @Override
    public Prescription deletePrescription(long pre_id) {

        Prescription prescription = getPrescriptionById(pre_id);
        prescriptionRepository.delete(prescription);

        return prescription;
    }

    @Override
    @Transactional
    public Prescription updatePrescription(long p_id, Prescription prescription) {
        Prescription prescription_edit = getPrescriptionById(p_id);
        prescription_edit.setPrescription_date(prescription.getPrescription_date());
        prescription_edit.setPrescription(prescription.getPrescription());
        prescription_edit.setDosage(prescription.getDosage());
        return prescription_edit;
    }


}
