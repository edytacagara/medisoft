/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.doctor;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author michal.zahir
 */
@Entity
@Table(name = "DIAGNOSIS", catalog = "", schema = "MEDISOFT")
@NamedQueries({
    @NamedQuery(name = "Diagnosis.findAll", query = "SELECT d FROM Diagnosis d"),
    @NamedQuery(name = "Diagnosis.findById", query = "SELECT d FROM Diagnosis d WHERE d.id = :id"),
    @NamedQuery(name = "Diagnosis.findByPatientId", query = "SELECT d FROM Diagnosis d WHERE d.patientId = :patientId"),
    @NamedQuery(name = "Diagnosis.findByDiagnoses", query = "SELECT d FROM Diagnosis d WHERE d.diagnoses = :diagnoses"),
    @NamedQuery(name = "Diagnosis.findBySkierowanie", query = "SELECT d FROM Diagnosis d WHERE d.skierowanie = :skierowanie"),
    @NamedQuery(name = "Diagnosis.findByVisitId", query = "SELECT d FROM Diagnosis d WHERE d.visitId = :visitId")})
public class Diagnosis implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PATIENT_ID")
    private BigInteger patientId;
    @Column(name = "DIAGNOSES")
    private String diagnoses;
    @Column(name = "SKIEROWANIE")
    private String skierowanie;
    @Column(name = "VISIT_ID")
    private BigInteger visitId;

    public Diagnosis() {
    }

    public Diagnosis(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        BigDecimal oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public BigInteger getPatientId() {
        return patientId;
    }

    public void setPatientId(BigInteger patientId) {
        BigInteger oldPatientId = this.patientId;
        this.patientId = patientId;
        changeSupport.firePropertyChange("patientId", oldPatientId, patientId);
    }

    public String getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(String diagnoses) {
        String oldDiagnoses = this.diagnoses;
        this.diagnoses = diagnoses;
        changeSupport.firePropertyChange("diagnoses", oldDiagnoses, diagnoses);
    }

    public String getSkierowanie() {
        return skierowanie;
    }

    public void setSkierowanie(String skierowanie) {
        String oldSkierowanie = this.skierowanie;
        this.skierowanie = skierowanie;
        changeSupport.firePropertyChange("skierowanie", oldSkierowanie, skierowanie);
    }

    public BigInteger getVisitId() {
        return visitId;
    }

    public void setVisitId(BigInteger visitId) {
        BigInteger oldVisitId = this.visitId;
        this.visitId = visitId;
        changeSupport.firePropertyChange("visitId", oldVisitId, visitId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnosis)) {
            return false;
        }
        Diagnosis other = (Diagnosis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.medisoft.ui.doctor.Diagnosis[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
