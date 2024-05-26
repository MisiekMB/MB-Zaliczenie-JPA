package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.entity.*;
import com.capgemini.wsb.persistence.enums.Specialization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @PersistenceContext
    private EntityManager entityManager;

    private DoctorEntity doctor;
    private AddressEntity address;
    private PatientEntity patient;
    private VisitEntity visit;

    @Transactional
    @BeforeEach
    void setUp() {
        // Insert initial test data
        address = new AddressEntity();
        address.setAddressLine1("Test Line 1");
        address.setAddressLine2("Test Line 2");
        address.setCity("Test City");
        address.setPostalCode("12345");

        entityManager.persist(address);

        doctor = new DoctorEntity();
        doctor.setFirstName("Jan");
        doctor.setLastName("Kowalski");
        doctor.setTelephoneNumber("123456789");
        doctor.setEmail("jan_kowalski@gmail.com");
        doctor.setDoctorNumber("123456");
        doctor.setSpecialization(Specialization.SURGEON);
        doctor.setAddress(address);

        entityManager.persist(doctor);

        patient = new PatientEntity();
        patient.setFirstName("Marek");
        patient.setLastName("Kowalski");
        patient.setTelephoneNumber("123456789");
        patient.setEmail("marek_kowalski@gmail.com");
        patient.setPatientNumber("123456");
        patient.setDateOfBirth(LocalDate.of(1990, 1, 1));
        patient.setNextVisitDateTime(LocalDateTime.of(2023, 12, 1, 10, 0));
        patient.setAddress(address);

        visit = new VisitEntity();
        visit.setDescription("wizyta nfz");
        visit.setTime(LocalDateTime.of(2021, 1, 1, 12, 0));
        visit.setDoctor(doctor);
        visit.setPatient(patient);

        Set<VisitEntity> visits = new HashSet<>();
        visits.add(visit);
        patient.setVisits(visits);

        entityManager.persist(patient);
        entityManager.persist(visit);

        entityManager.flush();  // Ensure data is written to the database
    }

    @Transactional
    @Test
    void testDeletePatient_CascadeDeletesVisits_NotDoctors() {
        // Given
        Long patientId = patient.getId();

        // When
        patientService.deletePatient(patientId);

        // Then
        PatientEntity deletedPatient = entityManager.find(PatientEntity.class, patientId);
        assertThat(deletedPatient).isNull();

        VisitEntity deletedVisit = entityManager.find(VisitEntity.class, visit.getId());
        assertThat(deletedVisit).isNull();

        DoctorEntity existingDoctor = entityManager.find(DoctorEntity.class, doctor.getId());
        assertThat(existingDoctor).isNotNull();
    }

    @Transactional
    @Test
    void testGetPatientById_ReturnsCorrectTO() {
        // Given
        Long patientId = patient.getId();

        // When
        PatientTO patientTO = patientService.getPatientById(patientId);

        // Then
        assertThat(patientTO).isNotNull();
        assertThat(patientTO.getId()).isEqualTo(patientId);
        assertThat(patientTO.getFirstName()).isEqualTo("Marek");
        assertThat(patientTO.getLastName()).isEqualTo("Kowalski");
        assertThat(patientTO.getTelephoneNumber()).isEqualTo("123456789");
        assertThat(patientTO.getEmail()).isEqualTo("marek_kowalski@gmail.com");
        assertThat(patientTO.getPatientNumber()).isEqualTo("123456");
        assertThat(patientTO.getDateOfBirth()).isEqualTo(LocalDate.of(1990, 1, 1));
        assertThat(patientTO.getNextVisitDateTime()).isEqualTo(LocalDateTime.of(2023, 12, 1, 10, 0));
        assertThat(patientTO.getVisits()).isNotNull();
        assertThat(patientTO.getVisits()).hasSize(1);

        VisitTO visitTO = patientTO.getVisits().iterator().next();
        assertThat(visitTO.getDescription()).isEqualTo("wizyta nfz");
        assertThat(visitTO.getVisitDate()).isEqualTo(LocalDate.of(2021, 1, 1));
        assertThat(visitTO.getDoctor().getFirstName()).isEqualTo("Jan");
    }

    @Test
    @Transactional
    public void testFindVisitsByPatientId() {
        // Given
        Long patientId = 1L;

        // When
        List<VisitTO> visits = patientService.findVisitsByPatientId(patientId);

        // Then
        assertThat(visits).isNotNull();
        assertThat(visits).hasSize(1); // Adjust the size based on actual data
        assertThat(visits.get(0).getDescription()).isEqualTo("wizyta nfz");

    }




}
