/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.domain.user;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Rafal
 */
@Entity
@Table(name = "USERS_ROLES", catalog = "", schema = "MEDISOFT")
@NamedQueries({
    @NamedQuery(name = "UsersRoles.findByUserId", query = "SELECT u FROM UsersRoles u WHERE u.usersRolesPK.userId = :userId")
    })
public class UsersRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected UsersRolesPK usersRolesPK;
    
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne
    private RoleDef roleDef;

    public UsersRoles() {
    }

    public UsersRoles(UsersRolesPK usersRolesPK) {
        this.usersRolesPK = usersRolesPK;
    }

    public UsersRoles(long userId, String roleId) {
        this.usersRolesPK = new UsersRolesPK(userId, roleId);
        this.roleDef = new RoleDef(roleId);
    }

    public UsersRolesPK getUsersRolesPK() {
        return usersRolesPK;
    }

    public void setUsersRolesPK(UsersRolesPK usersRolesPK) {
        this.usersRolesPK = usersRolesPK;
    }

    public RoleDef getRoleDef() {
        return roleDef;
    }

    public void setRoleDef(RoleDef roleDef) {
        this.roleDef = roleDef;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usersRolesPK != null ? usersRolesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof UsersRoles)) {
            return false;
        }
        UsersRoles other = (UsersRoles) object;
        if ((this.usersRolesPK == null && other.usersRolesPK != null) || (this.usersRolesPK != null && !this.usersRolesPK.equals(other.usersRolesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getRoleDef().toString();
    }
    
}