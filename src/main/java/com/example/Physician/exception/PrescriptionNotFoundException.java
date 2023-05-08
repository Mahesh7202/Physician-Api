package com.example.Physician.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PrescriptionNotFoundException extends RuntimeException{

    private String resourcename;
    private String perscription_id;
    private String patient_id;

    public PrescriptionNotFoundException(Long p_id){
        super(MessageFormat.format("could not fint patient with id:{0}",p_id));
    }

    public PrescriptionNotFoundException(String resourcename, String perscription_id, String patient_id) {
        super("i will write it latererrrrrrrrrrrrrrr");
        this.resourcename = resourcename;
        this.perscription_id = perscription_id;
        this.patient_id = patient_id;
    }

    public String getResourcename() {
        return resourcename;
    }

    public void setResourcename(String resourcename) {
        this.resourcename = resourcename;
    }

    public String getPerscription_id() {
        return perscription_id;
    }

    public void setPerscription_id(String perscription_id) {
        this.perscription_id = perscription_id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }
}
