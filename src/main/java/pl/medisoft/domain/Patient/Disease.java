/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.domain.Patient;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Kamil Ochnio
 */
@Entity
@Table(name = "DISEASE",schema = "MEDISOFT")        
class Disease implements Serializable{
    
    @Id
    @GeneratedValue
    private long Id;

    @Column(name = "ICD_10")
    private String ICD_10;
    @Column(name = "DESCRIPTION")
    private String description;
    
    public Disease() {
    }

    public Disease(long Id, String ICD_10, String description) {
        this.Id = Id;
        this.ICD_10 = ICD_10;
        this.description = description;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getICD_10() {
        return ICD_10;
    }

    public void setICD_10(String ICD_10) {
        this.ICD_10 = ICD_10;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
