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
@Table(name = "VISIT_TYPE",schema = "MEDISOFT")
public class VisitType implements Serializable{
    
    @Id
    @GeneratedValue
    private long Id;
    @Column(name = "DESCRIPTION")
    private String Description;

    public VisitType(long Id, String Description) {
        this.Id = Id;
        this.Description = Description;
    }

    public VisitType() {
    }
   
    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
 
    
}
