/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.domain.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Mariusz Batyra
 */
@Entity
@Table(name = "PARAM_DEF", schema = "MEDISOFT")
public class ParamDef implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String description;

    public ParamDef() {

    }

    public ParamDef(String id) {
        this.id = id;
    }

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
