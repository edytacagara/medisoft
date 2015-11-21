/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.application.message;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import pl.medisoft.application.common.PropertiesLoader;
import pl.medisoft.application.identity.IdentityProvider;
import pl.medisoft.application.user.param.UserParamBean;

/**
 *
 * @author Mariusz Batyra
 */
public class Messages {

    private static final String ENCODING_ISO = "ISO-8859-1";
    private static final String ENCODING_UTF8 = "UTF-8";
    private static final LanguageEnum DEFAULT_LANG = LanguageEnum.PL;

    private static Messages instace = null;
    private Properties properties;
    private static LanguageEnum currentLanguage = null;

    private Messages() {
        properties = PropertiesLoader.getProperties(getClass(), currentLanguage.getFilename());
    }

    public static Messages getInstace() {
        if (instace == null) {
            if (currentLanguage == null) {
                if (IdentityProvider.identity != null) {
                    UserParamBean userParamBean = new UserParamBean();
                    LanguageEnum userLanguage = userParamBean.getUserLanguage(IdentityProvider.identity.getId());
                    currentLanguage = (userLanguage == null ? DEFAULT_LANG : userLanguage);
                } else {
                    currentLanguage = DEFAULT_LANG;
                }
            }
            instace = new Messages();
        }
        return instace;
    }

    public static void clearInstance() {
        instace = null;
        currentLanguage = null;
    }
    
    public void changeLanguage(final LanguageEnum language) {
        if (language != null) {
            Messages.currentLanguage = language;
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
