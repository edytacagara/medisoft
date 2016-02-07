/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.doctor;

import java.util.List;
import pl.medisoft.infrastructure.BasicDaoJpa;
import pl.medisoft.ui.doctor.Doctor;

/**
 *
 * @author Edyta Cagara
 */
public class DoctorDaoJpa extends BasicDaoJpa implements DoctorDao{

    private static final String FIND_ALL = "select d from Doctor d";
    
    @Override
    public List<Doctor> findAll() {
        return getEntityManager().createQuery(FIND_ALL).getResultList();
    }
    
}
