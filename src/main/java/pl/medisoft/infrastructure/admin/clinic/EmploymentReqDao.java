/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.admin.clinic;

import java.util.List;
import pl.medisoft.domain.admin.clinic.EmploymentReq;

/**
 *
 * @author Edyta Cagara
 */
public interface EmploymentReqDao {
    public List<EmploymentReq> findAll();
    //public int getTotalWorktime(RoleDef roleDef);
}
