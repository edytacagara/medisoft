/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.visit;

import java.util.List;
import pl.medisoft.domain.Patient.Visit;
import pl.medisoft.domain.Patient.VisitType;

/**
 *
 * @author Mariusz Batyra
 */
public interface VisitDao {
    
    List<Visit> findAllVisit(Long userId, String date);
    List<VisitType> findAllVisitType(); 
    void addVisit(Visit visit);

    
}
