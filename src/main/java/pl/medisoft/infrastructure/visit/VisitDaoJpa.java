/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.visit;

import java.util.List;
import pl.medisoft.domain.Patient.Visit;
import pl.medisoft.infrastructure.BasicDaoJpa;

/**
 *
 * @author Mariusz Batyra
 */
public class VisitDaoJpa extends BasicDaoJpa implements VisitDao {

    private static final String ALL_VISIT = "select visit from Visit visit "
            + " where (visit.patient.id = :userId or visit.doctor.id = :userId) "
            + " and TO_CHAR(visit.visitDate, 'yyyy-mm-dd') = :date"
            + " order by visit.visitDate asc";

    @Override
    public List<Visit> findAllVisit(Long userId, String date) {
        return getEntityManager().createQuery(ALL_VISIT)
                .setParameter("userId", userId)
                .setParameter("date", date).getResultList();
    }

}
