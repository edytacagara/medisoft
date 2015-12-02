/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.domain.user;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import pl.medisoft.domain.admin.clinic.EmploymentReq;

/**
 *
 * @author Mariusz Batyra
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "RoleDef.findAllAvailableByUserId", query = "SELECT u FROM RoleDef u where u.id not in (select ur.usersRolesPK.roleId from UsersRoles ur where ur.usersRolesPK.userId = :userId)")
    })
@Table(name = "ROLES_DEF", catalog = "", schema = "MEDISOFT")
public class RoleDef implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String id;
    private String description;
    private EmploymentReq employmentReq;
    
    public RoleDef() {

    }

    public RoleDef(String id) {
        this.id = id;
    }

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description; //To change body of generated methods, choose Tools | Templates.
    }

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "roleDef")
    public EmploymentReq getEmploymentReq() {
        return employmentReq;
    }

    public void setEmploymentReq(EmploymentReq employmentReq) {
        this.employmentReq = employmentReq;
    }
    
    

}
