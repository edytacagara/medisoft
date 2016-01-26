/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.domain.pharmacy;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Piotr
 */
@Entity
@Table(name = "MEDICAMENT")

public class Medicament implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "MEDICAMENT_NAME")
    private String medicamentName;
    @Column(name = "DISEASE")
    private String disease;
    @Column(name = "MEASURE")
    private String measure;
    @Column(name = "AMOUNT")
    private Double amount;
    @Column(name = "PRICE")
    private Double price;

    public Medicament() {
        
    }

    public Medicament(Long id, String medicamentName, String disease, String measure, Double amount, Double price) {
        this.id = id;
        this.medicamentName = medicamentName;
        this.disease = disease;
        this.measure = measure;
        this.amount = amount;
        this.price = price;
    }
    
    

    public Medicament(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicamentName() {
        return medicamentName;
    }

    public void setMedicamentName(String medicamentName) {
        this.medicamentName = medicamentName;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
        if (!(object instanceof Medicament)) {
            return false;
        }
        Medicament other = (Medicament) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.medisoft.domain.pharmacy.Medicament[ id=" + id + " ]";
    }
    
}
