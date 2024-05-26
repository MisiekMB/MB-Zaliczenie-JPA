package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private VisitMapper visitMapper;

    @Transactional
    @Override
    public List<PatientTO> getAllPatients() {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "SELECT p FROM PatientEntity p", PatientEntity.class);
        return query.getResultList().stream()
                .map(PatientMapper::toPatientTO)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public PatientTO getPatientById(Long id) {
        PatientEntity entity = entityManager.find(PatientEntity.class, id);
        return entity != null ? PatientMapper.toPatientTO(entity) : null;
    }

    @Transactional
    @Override
    public PatientTO savePatient(PatientTO patientTO) {
        PatientEntity entity = PatientMapper.toPatientEntity(patientTO);
        if (entity.getId() == null) {
            entityManager.persist(entity);
        } else {
            entity = entityManager.merge(entity);
        }
        return PatientMapper.toPatientTO(entity);
    }

    @Transactional
    @Override
    public void deletePatient(Long id) {
        PatientEntity entity = entityManager.find(PatientEntity.class, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<PatientTO> findPatientsByLastName(String lastName) {
        return patientDao.findByLastName(lastName).stream()
                .map(PatientMapper::toPatientTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<VisitTO> findVisitsByPatientId(Long patientId) {
        PatientEntity patientEntity = entityManager.find(PatientEntity.class, patientId);
        if (patientEntity != null) {
            return patientEntity.getVisits().stream()
                    .map(VisitMapper::toVisitTO)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
