package com.example.Physician.exception;

import java.text.MessageFormat;

public class PatientNotFoundException extends RuntimeException{

    public PatientNotFoundException(long p_id) {
        super(MessageFormat.format("patient not found with the id:{0}", p_id));
    }
}
