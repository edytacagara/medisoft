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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Piotr
 */
@Entity
@Table(name = "EXCHANGE")
public class Exchange implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
   
    @Column(name = "MEDICAMENT_ID")
    private Long medicament;
   
    @Column(name = "EXCHANGE_NAME")
    private String exchangeName;

    public Exchange() {
    }

    public Exchange(Long id) {
        this.id = id;
    }

    public Exchange(Long id, Long medicament, String exchangeName) {
        this.id = id;
        this.medicament = medicament;
        this.exchangeName = exchangeName;
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

 

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
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
        if (!(object instanceof Exchange)) {
            return false;
        }
        Exchange other = (Exchange) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.medisoft.domain.pharmacy.Exchange[ id=" + id + " ]";
    }
    
}
