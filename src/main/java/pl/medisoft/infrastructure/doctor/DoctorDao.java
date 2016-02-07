/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.doctor;

import java.util.List;
import pl.medisoft.ui.doctor.Doctor;

/**
 *
 * @author Edyta Cagara
 */
public interface DoctorDao {
    public List<Doctor> findAll();
}
