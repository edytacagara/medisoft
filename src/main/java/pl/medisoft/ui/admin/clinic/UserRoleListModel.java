/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.admin.clinic;

import java.util.List;
import javax.swing.AbstractListModel;
import pl.medisoft.domain.admin.clinic.EmploymentReq;
import pl.medisoft.domain.user.RoleDef;
import pl.medisoft.infrastructure.admin.clinic.EmploymentReqDao;
import pl.medisoft.infrastructure.admin.clinic.EmploymentReqDaoJpa;

/**
 *
 * @author Edyta Cagara
 */
public class UserRoleListModel extends AbstractListModel{

    private EmploymentReqDao employmentReqDaoJpa;
    private List<EmploymentReq> employmentReqs;
    
    public UserRoleListModel(){
        super();
        this.employmentReqDaoJpa = new EmploymentReqDaoJpa();
        this.employmentReqs = employmentReqDaoJpa.findAll();
    }
    
    @Override
    public int getSize() {
        return this.employmentReqs.size();
    }

    @Override
    public Object getElementAt(int index) {
        return this.employmentReqs.get(index).getRoleDef();
    }
    
}
