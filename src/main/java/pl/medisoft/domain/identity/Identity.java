/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.domain.identity;

/**
 *
 * @author Mariusz Batyra
 */
public class Identity {

    private Long id;
    private String pesel;
    private String name;
    private String surname;

    public Identity() {

    }

    public Identity(Long id, String pesel, String name, String surname) {
        this.id = id;
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }
    
    public String getPesel() {
        return pesel;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

}
