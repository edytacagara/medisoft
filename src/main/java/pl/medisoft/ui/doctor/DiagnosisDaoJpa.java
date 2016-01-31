/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.doctor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import pl.medisoft.infrastructure.BasicDaoJpa;

/**
 *
 * @author michal.zahir
 */
public class DiagnosisDaoJpa extends BasicDaoJpa implements DiagnosisDao {

    private static final String ONE_PATIENT_DIAGNOSIS = "select diag from Diagnosis diag "
            + " where (diag.patientId  = :patientId ) ";
    private static final String NEXT_VAL = "select DIAGNOSIS_SEQ.nextval  from dual";

//DIAGNOSES, SKIEROWANIE, VISIT_ID
    @Override
    public List<Diagnosis> findAllVisit(Long PatientId) {
        return getEntityManager().createQuery(ONE_PATIENT_DIAGNOSIS)
                .setParameter("patientId", BigInteger.valueOf(PatientId))
                .getResultList();
    }

    @Override
    public boolean addDiagnosis(Diagnosis d) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(d);
            getEntityManager().getTransaction().commit();
            return true;
        } catch (Exception e) {
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
