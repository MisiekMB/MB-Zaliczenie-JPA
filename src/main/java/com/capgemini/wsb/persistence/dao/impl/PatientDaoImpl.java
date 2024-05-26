package com.capgemini.wsb.persistence.dao.impl;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;


@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Override
    public List<PatientEntity> findByLastName(String lastName) {
        return entityManager.createQuery(
                        "SELECT p FROM PatientEntity p WHERE p.lastName = :lastName", PatientEntity.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsWithMoreThanXVisits(int numberOfVisits) {
        String queryStr = "SELECT p FROM PatientEntity p LEFT JOIN FETCH p.visits WHERE SIZE(p.visits) > :numberOfVisits";
        TypedQuery<PatientEntity> query = entityManager.createQuery(queryStr, PatientEntity.class);
        query.setParameter("numberOfVisits", numberOfVisits);
        return query.getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsWithNextVisitAfter(LocalDateTime dateTime) {
        String query = "SELECT p FROM PatientEntity p WHERE p.nextVisitDateTime > :dateTime";
        return entityManager.createQuery(query, PatientEntity.class)
                .setParameter("dateTime", dateTime)
                .getResultList();
    }
}

