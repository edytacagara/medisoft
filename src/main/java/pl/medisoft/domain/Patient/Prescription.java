/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.domain.Patient;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author michal.zahir
 */
@Entity
@SequenceGenerator(name = "MEDISOFT.PRESCRIPTION_SEQ", initialValue = 1)
@Table(name = "PRESCRIPTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prescription.findAll", query = "SELECT p FROM Prescription p"),
    @NamedQuery(name = "Prescription.findById", query = "SELECT p FROM Prescription p WHERE p.id = :id"),
    @NamedQuery(name = "Prescription.findByPatientId", query = "SELECT p FROM Prescription p WHERE p.patientId = :patientId"),
    @NamedQuery(name = "Prescription.findByDoctorId", query = "SELECT p FROM Prescription p WHERE p.doctorId = :doctorId"),
    @NamedQuery(name = "Prescription.findByValidDate", query = "SELECT p FROM Prescription p WHERE p.validDate = :validDate"),
    @NamedQuery(name = "Prescription.findByQuantityValue", query = "SELECT p FROM Prescription p WHERE p.quantityValue = :quantityValue"),
    @NamedQuery(name = "Prescription.findByMedicamentId", query = "SELECT p FROM Prescription p WHERE p.medicamentId = :medicamentId"),
    @NamedQuery(name = "Prescription.findByDescription", query = "SELECT p FROM Prescription p WHERE p.description = :description"),
    @NamedQuery(name = "Prescription.findByDateOfIssue", query = "SELECT p FROM Prescription p WHERE p.dateOfIssue = :dateOfIssue"),
    @NamedQuery(name = "Prescription.findByPatientName", query = "SELECT p FROM Prescription p WHERE p.patientName = :patientName")})
public class Prescription implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEDISOFT.PRESCRIPTION_SEQ")
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PATIENT_ID")
    private BigInteger patientId;
    @Column(name = "DOCTOR_ID")
    private BigInteger doctorId;
    @Column(name = "VALID_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validDate;
    @Column(name = "QUANTITY_VALUE")
    private BigInteger quantityValue;
    @Column(name = "MEDICAMENT_ID")
    private BigInteger medicamentId;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "DATE_OF_ISSUE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfIssue;
    @Column(name = "PATIENT_NAME")
    private String patientName;

    public Prescription() {
    }

    public Prescription(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getPatientId() {
        return patientId;
    }

    public void setPatientId(BigInteger patientId) {
        this.patientId = patientId;
    }

    public BigInteger getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(BigInteger doctorId) {
        this.doctorId = doctorId;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public BigInteger getQuantityValue() {
        return quantityValue;
    }

    public void setQuantityValue(BigInteger quantityValue) {
        this.quantityValue = quantityValue;
    }

    public BigInteger getMedicamentId() {
        return medicamentId;
    }

    public void setMedicamentId(BigInteger medicamentId) {
        this.medicamentId = medicamentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
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
        if (!(object instanceof Prescription)) {
            return false;
        }
        Prescription other = (Prescription) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.medisoft.domain.Patient.Prescription[ id=" + id + " ]";
    }

}
