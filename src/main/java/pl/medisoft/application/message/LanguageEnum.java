/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.application.message;

/**
 *
 * @author Mariusz Batyra
 */
public enum LanguageEnum {

    PL("pl", "messages_pl.properties"),
    EN("en", "messages_en.properties"),
    DE("de", "messages_de.properties");

    private final String id;
    private final String filename;

    private LanguageEnum(final String id, final String filename) {
        this.id = id;
        this.filename = filename;
    }

    public String getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public static LanguageEnum fromValue(final String value) {
        for (LanguageEnum language : LanguageEnum.values()) {
            if (language.getId().equalsIgnoreCase(value)) {
                return language;
            }
        }
        return null;
    }

}
