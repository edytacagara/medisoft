/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.adminsys.dao;

import pl.medisoft.infrastructure.adminsys.dao.impl.UserRolesDaoImpl;

/**
 *
 * @author Rafal
 */
public class UserRoleDaoFactory {
    
     public static UserRoleDao getUserRoleDao(){
         return new UserRolesDaoImpl();
     }
    
}
