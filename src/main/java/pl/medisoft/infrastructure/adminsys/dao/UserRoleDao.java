/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.adminsys.dao;

import java.util.List;
import pl.medisoft.domain.user.RoleDef;
import pl.medisoft.domain.user.UsersRoles;

/**
 *
 * @author Rafal
 */
public interface UserRoleDao {
    
    public List<UsersRoles> getUserRoleByUserId(long userId);
    
    public List<RoleDef> getAvailableRolesByUserId(long userId);
    
    public void removeRole(UsersRoles usersRoles);
    
    public void addRole(RoleDef roleDef, long userId);
    
    
    
}
