/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.domain.pharmacy;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Piotr
 */
@Entity
@Table(name = "REPROCESSING")
public class Reprocessing implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "MEDICAMENT_ID")
    private Long medicament;
   
    @Column(name = "AMOUNT")
    private Double amount;

    public Reprocessing() {
    }

    public Reprocessing(Long id) {
        this.id = id;
    }

    public Reprocessing(Long id, Long medicament, Double amount) {
        this.id = id;
        this.medicament = medicament;
        this.amount = amount;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMedicament() {
        return medicament;
    }

    public void setMedicament(Long medicament) {
        this.medicament = medicament;
    }


    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
        if (!(object instanceof Reprocessing)) {
            return false;
        }
        Reprocessing other = (Reprocessing) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.medisoft.domain.pharmacy.Reprocessing[ id=" + id + " ]";
    }
    
}
