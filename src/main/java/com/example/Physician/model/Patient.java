package com.example.Physician.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Data
@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long patient_id;

    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "patient_id")
    private List<Prescription> prescriptions = new ArrayList<>();

    public Patient(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Patient(String firstname, String lastname, List<Prescription> prescription) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.prescriptions = prescription;
    }

    public void savePrescription(Prescription prescription){
        prescriptions.add(prescription);
    }

    public void deletePrescription(Prescription prescription){
        prescriptions.remove(prescription);
    }



}
