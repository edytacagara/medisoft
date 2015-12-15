/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.domain.Patient;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Kamil Ochnio
 */
@Entity
@Table(name = "PATIENT_HISTORY",schema = "MEDISOFT")
public class PatientHistory implements Serializable{
    @Id
    @GeneratedValue
    private long Id;    
    
    @JoinColumn(name = "VISIT_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)        
    private Visit visit;
    
    @OneToMany 
    private List<Disease> disease;
    
    @Column(name = "DIAGNOSIS")
    private String diagnosis;
    
    @JoinColumn(name = "PRESCRIPTION_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToMany 
    private List<Prescription> prescription;

    public PatientHistory() {
    }

    public PatientHistory(long Id, Visit visit, List<Disease> disease, String diagnosis, List<Prescription> prescription) {
        this.Id = Id;
        this.visit = visit;
        this.disease = disease;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public List<Disease> getDisease() {
        return disease;
    }

    public void setDisease(List<Disease> disease) {
        this.disease = disease;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public List<Prescription> getPrescription() {
        return prescription;
    }

    public void setPrescription(List<Prescription> prescription) {
        this.prescription = prescription;
    }
    
    
}
