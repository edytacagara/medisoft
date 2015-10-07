/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.application.configuration;

/**
 *
 * @author Mariusz Batyra
 */
public enum PropertiesEnum {

    TITLE("app.title"),
    VERSION("app.version");

    private final String name;

    private PropertiesEnum(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
