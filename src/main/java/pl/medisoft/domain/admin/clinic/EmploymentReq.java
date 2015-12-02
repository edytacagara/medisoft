/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.domain.admin.clinic;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import pl.medisoft.domain.user.RoleDef;

/**
 *
 * @author Edyta Cagara
 */
@Entity
@Table(name = "EMPLOYMENT_REQ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmploymentReq.findAll", query = "SELECT e FROM EmploymentReq e"),
    @NamedQuery(name = "EmploymentReq.findByRoleId", query = "SELECT e FROM EmploymentReq e WHERE e.roleId = :roleId"),
    @NamedQuery(name = "EmploymentReq.findByWorktimeReq", query = "SELECT e FROM EmploymentReq e WHERE e.worktimeReq = :worktimeReq"),
    @NamedQuery(name = "EmploymentReq.findBySalaryBase", query = "SELECT e FROM EmploymentReq e WHERE e.salaryBase = :salaryBase")})
public class EmploymentReq implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ROLE_ID")
    private String roleId;
    @Column(name = "WORKTIME_REQ")
    private BigInteger worktimeReq;
    @Column(name = "SALARY_BASE")
    private BigInteger salaryBase;
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private RoleDef roleDef;

    public EmploymentReq() {
    }

    public EmploymentReq(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public BigInteger getWorktimeReq() {
        return worktimeReq;
    }

    public void setWorktimeReq(BigInteger worktimeReq) {
        this.worktimeReq = worktimeReq;
    }

    public BigInteger getSalaryBase() {
        return salaryBase;
    }

    public void setSalaryBase(BigInteger salaryBase) {
        this.salaryBase = salaryBase;
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
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmploymentReq)) {
            return false;
        }
        EmploymentReq other = (EmploymentReq) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return roleDef.toString();
    }
    
}
