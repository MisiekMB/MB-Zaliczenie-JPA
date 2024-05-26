package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.stereotype.Component;

@Component
public class VisitMapper {

    public static VisitTO toVisitTO(VisitEntity entity) {
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

    public VisitEntity toVisitEntity(VisitTO to) {
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
