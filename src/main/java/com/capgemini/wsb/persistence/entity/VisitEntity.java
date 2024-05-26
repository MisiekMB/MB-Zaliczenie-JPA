package com.capgemini.wsb.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	@ManyToOne(optional = false) // Wiele wizyt może mieć jednego lekarza
	@JoinColumn(name = "doctor_id", nullable = false)
	private DoctorEntity doctor;  // Relacja dwustronna ze stroną dziecka

	@ManyToOne(optional = false) // Wiele wizyt może mieć jednego pacjenta
	@JoinColumn(name = "patient_id", nullable = false) //  Relacja dwustronna ze stroną dziecka
	private PatientEntity patient;

	@OneToMany(mappedBy = "visit", cascade = CascadeType.ALL, orphanRemoval = true) // Jeden do wielu, bo jedna wizyta może mieć wiele leczeń
	private Collection<MedicalTreatmentEntity> medical_treatment; // Relacja dwustronna ze stroną rodzica

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public DoctorEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	public Collection<MedicalTreatmentEntity> getMedical_treatment() {
		return medical_treatment;
	}

	public void setMedical_treatment(Collection<MedicalTreatmentEntity> medical_treatment) {
		this.medical_treatment = medical_treatment;
	}
}
