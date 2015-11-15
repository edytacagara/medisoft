/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.domain.user;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Rafal
 */
@Embeddable
public class UsersRolesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "USER_ID")
    private long userId;
    @Basic(optional = false)
    @Column(name = "ROLE_ID")
    private String roleId;

    public UsersRolesPK() {
    }

    public UsersRolesPK(long userId, String roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof UsersRolesPK)) {
            return false;
        }
        UsersRolesPK other = (UsersRolesPK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.medisoft.domain.user.UsersRolesPK[ userId=" + userId + ", roleId=" + roleId + " ]";
    }
    
}
