/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.doctor;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
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
import javax.persistence.Transient;


/**
 *
 * @author michal.zahir
 */
@Entity
@SequenceGenerator(name="MEDISOFT.DrSeq", initialValue=1)
@Table(name = "DOCTOR", catalog = "", schema = "MEDISOFT")
@NamedQueries({
    @NamedQuery(name = "Doctor.findAll", query = "SELECT d FROM Doctor d"),
    @NamedQuery(name = "Doctor.findByName", query = "SELECT d FROM Doctor d WHERE d.name = :name"),
    @NamedQuery(name = "Doctor.findBySpecialty", query = "SELECT d FROM Doctor d WHERE d.specialty = :specialty"),
    @NamedQuery(name = "Doctor.findByTitle", query = "SELECT d FROM Doctor d WHERE d.title = :title"),
    @NamedQuery(name = "Doctor.findByEmail", query = "SELECT d FROM Doctor d WHERE d.email = :email"),
    @NamedQuery(name = "Doctor.findByDateOfBirth", query = "SELECT d FROM Doctor d WHERE d.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Doctor.findByOfficeAddress", query = "SELECT d FROM Doctor d WHERE d.officeAddress = :officeAddress"),
    @NamedQuery(name = "Doctor.findByOfficePhone", query = "SELECT d FROM Doctor d WHERE d.officePhone = :officePhone"),
    @NamedQuery(name = "Doctor.findByExperienceYears", query = "SELECT d FROM Doctor d WHERE d.experienceYears = :experienceYears"),
    @NamedQuery(name = "Doctor.findById", query = "SELECT d FROM Doctor d WHERE d.id = :id"),
    @NamedQuery(name = "Doctor.findByLastName", query = "SELECT d FROM Doctor d WHERE d.lastName = :lastName"),
    @NamedQuery(name = "Doctor.findByPhoneNumber", query = "SELECT d FROM Doctor d WHERE d.phoneNumber = :phoneNumber")})
public class Doctor implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "SPECIALTY")
    private String specialty;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "DATE_OF_BIRTH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;
    @Basic(optional = false)
    @Column(name = "OFFICE_ADDRESS")
    private String officeAddress;
    @Basic(optional = false)
    @Column(name = "OFFICE_PHONE")
    private BigInteger officePhone;
    @Column(name = "EXPERIENCE_YEARS")
    private Short experienceYears;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEDISOFT.DrSeq")
    private Long id;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    public Doctor() {
    }

    public Doctor(Long id) {
        this.id = id;
    }

    public Doctor(Long id, String name, Date dateOfBirth, String officeAddress, BigInteger officePhone) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.officeAddress = officeAddress;
        this.officePhone = officePhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        String oldSpecialty = this.specialty;
        this.specialty = specialty;
        changeSupport.firePropertyChange("specialty", oldSpecialty, specialty);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        String oldTitle = this.title;
        this.title = title;
        changeSupport.firePropertyChange("title", oldTitle, title);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        Date oldDateOfBirth = this.dateOfBirth;
        this.dateOfBirth = dateOfBirth;
        changeSupport.firePropertyChange("dateOfBirth", oldDateOfBirth, dateOfBirth);
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        String oldOfficeAddress = this.officeAddress;
        this.officeAddress = officeAddress;
        changeSupport.firePropertyChange("officeAddress", oldOfficeAddress, officeAddress);
    }

    public BigInteger getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(BigInteger officePhone) {
        BigInteger oldOfficePhone = this.officePhone;
        this.officePhone = officePhone;
        changeSupport.firePropertyChange("officePhone", oldOfficePhone, officePhone);
    }

    public Short getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Short experienceYears) {
        Short oldExperienceYears = this.experienceYears;
        this.experienceYears = experienceYears;
        changeSupport.firePropertyChange("experienceYears", oldExperienceYears, experienceYears);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        String oldLastName = this.lastName;
        this.lastName = lastName;
        changeSupport.firePropertyChange("lastName", oldLastName, lastName);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        String oldPhoneNumber = this.phoneNumber;
        this.phoneNumber = phoneNumber;
        changeSupport.firePropertyChange("phoneNumber", oldPhoneNumber, phoneNumber);
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
        if (!(object instanceof Doctor)) {
            return false;
        }
        Doctor other = (Doctor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.medisoft.ui.doctor.Doctor[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
