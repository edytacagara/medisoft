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
import pl.medisoft.infrastructure.user.UserDaoJpa;

/**
 *
 * @author Edyta Cagara
 */
public class PatientComboBoxModel extends DefaultComboBoxModel<User>{
    private final UserDaoJpa userDaoJpa;
    private List<User> patients;
    
    public PatientComboBoxModel(){
        super();
        this.patients = new ArrayList<User>();
        this.userDaoJpa = new UserDaoJpa();
        List<User> users = userDaoJpa.findAllEmployees();
        Iterator<User> i = users.iterator();
        while(i.hasNext()){
            User user = i.next();
            Iterator<RoleDef> r = user.getUserRoles().iterator();
            while(r.hasNext()){
                if(r.next().getId().equals("PATIENT"))
                    this.patients.add(user);
            }
        }
    }
    
    @Override
    public int getSize(){
        return patients.size();
    }
    
    @Override
    public User getElementAt(int index){
        return this.patients.get(index);
    }
}
