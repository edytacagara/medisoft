/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.adminsys.dao.impl;

import java.util.ArrayList;
import java.util.List;
import pl.medisoft.domain.user.RoleDef;
import pl.medisoft.domain.user.UsersRoles;
import pl.medisoft.infrastructure.BasicDaoJpa;
import pl.medisoft.infrastructure.adminsys.dao.UserRoleDao;

/**
 *
 * @author Rafal
 */
public class UserRolesDaoImpl extends BasicDaoJpa implements UserRoleDao{

    @Override
    public List<UsersRoles> getUserRoleByUserId(long userId) {
        List<UsersRoles> userRoles = new ArrayList<>();
        userRoles = this.getEntityManager().createNamedQuery("UsersRoles.findByUserId", UsersRoles.class).setParameter("userId", userId).getResultList();
        return userRoles;
    }

    @Override
    public List<RoleDef> getAvailableRolesByUserId(long userId) {
        List<RoleDef> availableRoles = new ArrayList<>();
        availableRoles = this.getEntityManager().createNamedQuery("RoleDef.findAllAvailableByUserId", RoleDef.class).setParameter("userId", userId).getResultList();
        return availableRoles;
    }

    @Override
    public void removeRole(UsersRoles usersRoles) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addRole(RoleDef roleDef, long userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
