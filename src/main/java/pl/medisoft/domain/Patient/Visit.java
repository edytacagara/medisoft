/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.domain.Patient;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import pl.medisoft.domain.identity.*;
import pl.medisoft.domain.user.User;

/**
 *
 * @author Kamil Ochnio
 */
@Entity
@Table(name = "VISIT", schema = "MEDISOFT")
public class Visit implements Serializable  {

    @Id
    @GeneratedValue
    private long id;
    
    @JoinColumn(name = "VISIT_TYPE_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)    
    private VisitType visitType;
    
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)    
    private User patient;
    
    @Column(name = "VISIT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date VisitDate;
    
    @JoinColumn(name = "DOCTOR_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)    
    private User doctor;

    public Visit() {
    }

    public Visit(long id, VisitType visitType, User patient, Date VisitDate, User doctor) {
        this.id = id;
        this.visitType = visitType;
        this.patient = patient;
        this.VisitDate = VisitDate;
        this.doctor = doctor;
    }

    public Date getVisitDate() {
        return VisitDate;
    }

    public void setVisitDate(Date VisitDate) {
        this.VisitDate = VisitDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public VisitType getVisitType() {
        return visitType;
    }

    public void setVisitType(VisitType visitType) {
        this.visitType = visitType;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

  

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }
    
    
   

  
    
}
