package com.capgemini.wsb.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class VisitTO implements Serializable {
    private Long id;
    private LocalDate visitDate;
    private String description;
    private PatientTO patient;
    private DoctorTO doctor;

    /* Gettery i settery */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PatientTO getPatient() {
        return patient;
    }

    public void setPatient(PatientTO patient) {
        this.patient = patient;
    }

    public DoctorTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorTO doctor) {
        this.doctor = doctor;
    }
}
