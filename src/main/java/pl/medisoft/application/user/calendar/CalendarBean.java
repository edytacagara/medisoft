/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.application.user.calendar;

import java.util.List;
import pl.medisoft.application.identity.IdentityProvider;
import pl.medisoft.domain.Patient.Visit;
import pl.medisoft.infrastructure.visit.VisitDao;
import pl.medisoft.infrastructure.visit.VisitDaoJpa;

/**
 *
 * @author Mariusz Batyra
 */
public class CalendarBean {

    private final VisitDao visitDao = new VisitDaoJpa();

    public List<Visit> findAllVisit(String date) {
        return visitDao.findAllVisit(IdentityProvider.identity.getId(), date);
    }

}
