/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.doctor;

import java.util.List;

/**
 *
 * @author michal.zahir
 */
public interface DiagnosisDao {
    
      
    List<Diagnosis> findAllVisit(Long PatientId);
    boolean addDiagnosis(Diagnosis d);
    Long getNextValueSeq();

    
}
