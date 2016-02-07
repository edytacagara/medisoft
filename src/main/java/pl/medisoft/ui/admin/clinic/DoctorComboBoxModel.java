/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.admin.clinic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import pl.medisoft.domain.user.RoleDef;
import pl.medisoft.domain.user.User;
import pl.medisoft.infrastructure.doctor.DoctorDao;
import pl.medisoft.infrastructure.doctor.DoctorDaoJpa;
import pl.medisoft.infrastructure.user.UserDaoJpa;
import pl.medisoft.ui.doctor.Doctor;

/**
 *
 * @author Edyta Cagara
 */
public class DoctorComboBoxModel extends DefaultComboBoxModel<Doctor>{
    
    private final DoctorDao doctorDao;
    private List<Doctor> doctors;
    
    public DoctorComboBoxModel(){
        super();
        this.doctorDao = new DoctorDaoJpa();
        this.doctors = doctorDao.findAll();
    }
    
    @Override
    public int getSize(){
        return doctors.size();
    }
    
    @Override
    public Doctor getElementAt(int index){
        return this.doctors.get(index);
    }
}
