/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.visit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import pl.medisoft.domain.Patient.Visit;
import pl.medisoft.domain.Patient.VisitType;
import pl.medisoft.infrastructure.BasicDaoJpa;

/**
 *
 * @author Mariusz Batyra
 */
public class VisitDaoJpa extends BasicDaoJpa implements VisitDao {

    private static final String FIND_ALL = "select v from VisitType v";
    private static final String ALL_VISIT = "select visit from Visit visit "
            + " where (visit.patient.id = :userId or visit.doctor.id = :userId) "
            + " and TO_CHAR(visit.visitDate, 'yyyy-mm-dd') = :date"
            + " order by visit.visitDate asc";
    private static final String NEXT_VAL = "select VISIT_ID_SEQ.nextval  from dual";

    @Override
    public List<Visit> findAllVisit(Long userId, String date) {
        return getEntityManager().createQuery(ALL_VISIT)
                .setParameter("userId", userId)
                .setParameter("date", date).getResultList();
    }

    @Override
    public List<VisitType> findAllVisitType() {
        List<VisitType> visitType = new ArrayList();
        visitType = this.getEntityManager().createQuery(this.FIND_ALL).getResultList();
        return visitType;
    }

    @Override
    public boolean addVisit(Visit visit) {
        try {
            getEntityManager().getTransaction().begin();            
            getEntityManager().persist(visit);
            getEntityManager().getTransaction().commit();
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
            return false;
        }
    }
    

       @Override
    public Long getNextValueSeq() {
        final BigDecimal result = (BigDecimal) getEntityManager().createNativeQuery(NEXT_VAL)
                .getSingleResult();
        return result.longValue();
    }
}
