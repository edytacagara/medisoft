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
public class DoctorComboBoxModel extends DefaultComboBoxModel<User>{
    
    private final UserDaoJpa userDaoJpa;
    private List<User> doctors;
    
    public DoctorComboBoxModel(){
        super();
        this.doctors = new ArrayList<User>();
        this.userDaoJpa = new UserDaoJpa();
        List<User> users = userDaoJpa.findAllEmployees();
        Iterator<User> i = users.iterator();
        while(i.hasNext()){
            User user = i.next();
            Iterator<RoleDef> r = user.getUserRoles().iterator();
            while(r.hasNext()){
                if(r.next().getId().equals("DOCTOR"))
                    this.doctors.add(user);
            }
        }
    }
    
    @Override
    public int getSize(){
        return doctors.size();
    }
    
    @Override
    public User getElementAt(int index){
        return this.doctors.get(index);
    }
}
