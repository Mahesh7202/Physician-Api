package com.example.Physician.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.bytebuddy.utility.nullability.MaybeNull;

import java.time.LocalDate;

@Data
@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long prescription_id;

    @Column(name = "prescription_date",nullable = false)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate prescription_date = LocalDate.now();

    @Column(name = "prescription",nullable = false)
    private String prescription;

    @Column(name = "dosage")
    private String dosage;

    @ManyToOne
    private Patient patient;

    public Prescription(LocalDate prescription_date, String prescription, String dosage) {
        this.prescription_date = prescription_date;
        this.prescription = prescription;
        this.dosage = dosage;
    }

}
