/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.application.configuration;

import java.util.Properties;
import pl.medisoft.application.common.PropertiesLoader;

/**
 *
 * @author Mariusz Batyra
 */
public class ConfigurationLoader {

    private static final String PROPERTIES_FILENAME = "conf.properties";

    public ConfigurationLoader() {
        final Properties properties = PropertiesLoader.getProperties(getClass(), PROPERTIES_FILENAME);
        if (properties != null) {
            Configuration.TITLE = properties.getProperty(PropertiesEnum.TITLE.getName());
            Configuration.VERSION = properties.getProperty(PropertiesEnum.VERSION.getName());
        }
    }

}
