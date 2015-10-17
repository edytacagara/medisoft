/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.application.message;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import pl.medisoft.application.common.PropertiesLoader;

/**
 *
 * @author Mariusz Batyra
 */
public class Messages {

    private static final String ENCODING_ISO = "ISO-8859-1";
    private static final String ENCODING_UTF8 = "UTF-8";

    private static Messages instace = null;
    private Properties properties;
    private LanguageEnum currentLanguage = LanguageEnum.PL;

    private Messages() {
        properties = PropertiesLoader.getProperties(getClass(), currentLanguage.getFilename());
    }

    public static Messages getInstace() {
        if (instace == null) {
            instace = new Messages();
        }
        return instace;
    }

    public void changeLanguage(final LanguageEnum language) {
        if (language != null) {
            this.currentLanguage = language;
            properties = PropertiesLoader.getProperties(getClass(), currentLanguage.getFilename());
        }
    }

    public String get(final String key) {
        String value = (String) properties.get(key);

        try {
            value = value == null ? key : value;
            return new String(value.getBytes(ENCODING_ISO), ENCODING_UTF8);
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            return key;
        }
    }
}
