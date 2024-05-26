package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;

public class DoctorMapper {

    public static DoctorTO toDoctorTO(DoctorEntity entity) {
        if (entity == null) {
            return null;
        }

        DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(entity.getId());
        doctorTO.setFirstName(entity.getFirstName());
        doctorTO.setLastName(entity.getLastName());
        doctorTO.setTelephoneNumber(entity.getTelephoneNumber());
        doctorTO.setEmail(entity.getEmail());
        doctorTO.setDoctorNumber(entity.getDoctorNumber());
        doctorTO.setSpecialization(entity.getSpecialization());
        return doctorTO;
    }

    public static DoctorEntity toDoctorEntity(DoctorTO to) {
        if (to == null) {
            return null;
        }

        DoctorEntity entity = new DoctorEntity();
        entity.setId(to.getId());
        entity.setFirstName(to.getFirstName());
        entity.setLastName(to.getLastName());
        entity.setTelephoneNumber(to.getTelephoneNumber());
        entity.setEmail(to.getEmail());
        entity.setDoctorNumber(to.getDoctorNumber());
        entity.setSpecialization(to.getSpecialization());
        return entity;
    }
}
