/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.application.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mariusz Batyra
 */
public class ConfigurationLoader {

    private static final Logger LOG = Logger.getLogger(ConfigurationLoader.class.getName());
    private static final String PROPERTIES_FILENAME = "conf.properties";

    public ConfigurationLoader() {
        final Properties properties = getPorperties();
        if (properties != null) {
            Configuration.TITLE = properties.getProperty(PropertiesEnum.TITLE.getName());
            Configuration.VERSION = properties.getProperty(PropertiesEnum.VERSION.getName());
        }
    }

    private Properties getPorperties() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILENAME);
        Properties properties = new Properties();

        try {
            properties.load(inputStream);
            return properties;
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Problem with loading config file!\n{0}", ex.getMessage());
        }

        return null;
    }

}
