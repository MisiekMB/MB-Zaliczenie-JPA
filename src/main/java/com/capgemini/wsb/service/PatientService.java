package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;

import java.util.List;

public interface PatientService {
    List<PatientTO> getAllPatients();
    PatientTO getPatientById(Long id);
    PatientTO savePatient(PatientTO patientTO);
    void deletePatient(Long id);
    List<PatientTO> findPatientsByLastName(String lastName);
    List<VisitTO> findVisitsByPatientId(Long patientId);
}
