/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.admin.clinic;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import pl.medisoft.domain.admin.clinic.EmploymentReq;
import pl.medisoft.infrastructure.admin.clinic.EmploymentReqDaoJpa;

/**
 *
 * @author Edyta Cagara
 */
public class EmploymentRoleComboBoxModel extends DefaultComboBoxModel<EmploymentReq>{
    
    private EmploymentReqDaoJpa employmentReqDaoJpa;
    private List<EmploymentReq> employmentReqs;
    
    public EmploymentRoleComboBoxModel(){
        super();
        this.employmentReqDaoJpa = new EmploymentReqDaoJpa();
        this.employmentReqs = employmentReqDaoJpa.findAll();
    }
    
    @Override
    public int getSize(){
        return employmentReqs.size();
    }
    
    @Override
    public EmploymentReq getElementAt(int index){
        return this.employmentReqs.get(index);
    }
}
