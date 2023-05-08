package com.example.Physician.controller;

import com.example.Physician.model.Prescription;
import com.example.Physician.service.impl.PrescriptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
    private PrescriptionServiceImpl prescriptionServiceImpl;

    @Autowired
    public PrescriptionController(PrescriptionServiceImpl prescriptionServiceImpl) {
        this.prescriptionServiceImpl = prescriptionServiceImpl;
    }

    @PostMapping
    public ResponseEntity<Prescription> savePrescription(@RequestBody final Prescription prescriptionDto){
        Prescription prescription = prescriptionServiceImpl.savePrescription(prescriptionDto);
        return new ResponseEntity<>(prescription,HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Prescription>> getPrescriptions(){
        List<Prescription> prescriptions = prescriptionServiceImpl.getPrescription();
        return new ResponseEntity<>(prescriptions, HttpStatus.OK);
    }

    @GetMapping(value = "/{prescription_id}")
    public ResponseEntity<Prescription> getPrescription(@PathVariable final Long prescription_id){
        Prescription prescription = prescriptionServiceImpl.getPrescriptionById(prescription_id);
        return new ResponseEntity<>(prescription,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{prescription_id}")
    public ResponseEntity<Prescription> deletePrescription(@PathVariable final Long prescription_id){
        Prescription prescription = prescriptionServiceImpl.deletePrescription(prescription_id);
        return new ResponseEntity<>(prescription,HttpStatus.OK);
    }

    @PutMapping(value = "/{prescription_id}")
    public ResponseEntity<Prescription> updatePrescription(@PathVariable final Long prescription_id,
                                                              @RequestBody Prescription prescriptionDto){
        Prescription prescription_edit = prescriptionServiceImpl.updatePrescription(prescription_id,
                                                                                    prescriptionDto);
        return new ResponseEntity<>(prescription_edit,HttpStatus.OK);
    }

}

