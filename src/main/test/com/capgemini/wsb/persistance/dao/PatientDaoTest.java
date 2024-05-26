package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Test
    @Transactional
    public void testFindPatientsByLastName() {
        // given
        String lastName = "Wójcik";

        // when
        List<PatientEntity> patients = patientDao.findByLastName(lastName);

        // then
        assertThat(patients).hasSize(1); // Assuming you have 1 patient with last name "Wójcik"
        assertThat(patients.get(0).getLastName()).isEqualTo("Wójcik");
    }

    @Test
    public void testFindPatientsWithMoreThanXVisits() {
        // Given
        int numberOfVisits = 1;

        // When
        List<PatientEntity> patients = patientDao.findPatientsWithMoreThanXVisits(numberOfVisits);

        // Then
        assertThat(patients).isNotNull();
        assertThat(patients.size()).isGreaterThan(0); // Ensure there are patients with more than 1 visit

        // Print out patient IDs and their visit counts for debugging
        for (PatientEntity patient : patients) {
            System.out.println("Patient ID: " + patient.getId() + ", Visit Count: " + patient.getVisits().size());
            assertThat(patient.getVisits().size()).isGreaterThan(numberOfVisits);
        }
    }


    @Test
    @Transactional
    public void testFindPatientsWithNextVisitAfter() {
        // Given
        LocalDateTime dateTime = LocalDateTime.of(2023, 11, 01, 0, 0);

        // When
        List<PatientEntity> patients = patientDao.findPatientsWithNextVisitAfter(dateTime);

        // Then
        assertThat(patients).isNotNull();
        assertThat(patients.size()).isGreaterThan(0); // Assuming there are patients with nextVisitDateTime after the given date
        for (PatientEntity patient : patients) {
            assertThat(patient.getNextVisitDateTime()).isAfter(dateTime);
        }
    }
}