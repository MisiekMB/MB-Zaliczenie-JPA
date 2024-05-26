package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import java.util.stream.Collectors;

public class PatientMapper {

    public static PatientTO toPatientTO(PatientEntity entity) {
        if (entity == null) {
            return null;
        }

        PatientTO patientTO = new PatientTO();
        patientTO.setId(entity.getId());
        patientTO.setFirstName(entity.getFirstName());
        patientTO.setLastName(entity.getLastName());
        patientTO.setTelephoneNumber(entity.getTelephoneNumber());
        patientTO.setEmail(entity.getEmail());
        patientTO.setPatientNumber(entity.getPatientNumber());
        patientTO.setDateOfBirth(entity.getDateOfBirth());
        patientTO.setNextVisitDateTime(entity.getNextVisitDateTime());
        patientTO.setAddress(AddressMapper.mapToTO(entity.getAddress()));
        patientTO.setVisits(entity.getVisits().stream()
                .map(visitEntity -> {
                    VisitTO visitTO = toVisitTOWithoutPatient(visitEntity);
                    visitTO.setPatient(null); // Unikamy cyklicznych odwołań
                    return visitTO;
                })
                .collect(Collectors.toSet()));
        return patientTO;
    }

    public static PatientEntity toPatientEntity(PatientTO to) {
        if (to == null) {
            return null;
        }

        PatientEntity entity = new PatientEntity();
        entity.setId(to.getId());
        entity.setFirstName(to.getFirstName());
        entity.setLastName(to.getLastName());
        entity.setTelephoneNumber(to.getTelephoneNumber());
        entity.setEmail(to.getEmail());
        entity.setPatientNumber(to.getPatientNumber());
        entity.setDateOfBirth(to.getDateOfBirth());
        entity.setNextVisitDateTime(to.getNextVisitDateTime());
        entity.setAddress(AddressMapper.mapToEntity(to.getAddress()));
        entity.setVisits(to.getVisits().stream()
                .map(visitTO -> {
                    VisitEntity visitEntity = toVisitEntityWithoutPatient(visitTO);
                    visitEntity.setPatient(null); // Unikamy cyklicznych odwołań
                    return visitEntity;
                })
                .collect(Collectors.toSet()));
        return entity;
    }

    private static VisitTO toVisitTOWithoutPatient(VisitEntity entity) {
        if (entity == null) {
            return null;
        }

        VisitTO visitTO = new VisitTO();
        visitTO.setId(entity.getId());
        visitTO.setVisitDate(entity.getTime().toLocalDate());
        visitTO.setDescription(entity.getDescription());
        visitTO.setDoctor(DoctorMapper.toDoctorTO(entity.getDoctor()));
        return visitTO;
    }

    private static VisitEntity toVisitEntityWithoutPatient(VisitTO to) {
        if (to == null) {
            return null;
        }

        VisitEntity entity = new VisitEntity();
        entity.setId(to.getId());
        entity.setTime(to.getVisitDate().atStartOfDay());
        entity.setDescription(to.getDescription());
        entity.setDoctor(DoctorMapper.toDoctorEntity(to.getDoctor()));
        return entity;
    }
}
