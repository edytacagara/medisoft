/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.admin.clinic;

import java.util.ArrayList;
import java.util.List;
import pl.medisoft.domain.admin.clinic.EmploymentReq;
import pl.medisoft.domain.user.RoleDef;
import pl.medisoft.infrastructure.BasicDaoJpa;

/**
 *
 * @author Edyta Cagara
 */
public class EmploymentReqDaoJpa extends BasicDaoJpa implements EmploymentReqDao{

    private static final String FIND_ALL = "select e from EmploymentReq e";
    
    @Override
    public List<EmploymentReq> findAll() {
        List<EmploymentReq> employmentReqs = new ArrayList();
        employmentReqs = this.getEntityManager().createQuery(FIND_ALL).getResultList();
        return employmentReqs;
    }
    
}
