/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.domain.Patient;

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
@Table(name = "PRESCRIPTION_ITEMS",schema = "MEDISOFT")
public class PrescriptionItems {
    @Id
    @GeneratedValue
    private long Id;
    @Column(name = "PRESCRIPTION_ID")
    private Prescription prescription;
    
    
    
    
}
