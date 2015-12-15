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
import pl.medisoft.domain.user.User;

/**
 *
 * @author Kamil Ochnio
 */
@Entity
@Table(name = "PRESCRIPTION")        
class Prescription implements Serializable{    
    @Id
    private long Id;
    
    
}
