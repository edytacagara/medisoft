/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.admin.clinic;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import pl.medisoft.domain.user.User;
import pl.medisoft.infrastructure.user.UserDaoJpa;

/**
 *
 * @author Edyta Cagara
 */
public class EmployeeComboBoxModel extends DefaultComboBoxModel<User>{
    
    private UserDaoJpa userDaoJpa;
    private List<User> users;
    
    public EmployeeComboBoxModel(){
        super();
        this.userDaoJpa = new UserDaoJpa();
        this.users = userDaoJpa.findAllEmployees();
    }
    
    @Override
    public int getSize(){
        return users.size();
    }
    
    @Override
    public User getElementAt(int index){
        return this.users.get(index);
    }
    
    
}
