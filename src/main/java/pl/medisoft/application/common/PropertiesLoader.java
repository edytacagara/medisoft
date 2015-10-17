/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.application.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mariusz Batyra
 */
public class PropertiesLoader {

    private static final Logger LOG = Logger.getLogger(PropertiesLoader.class.getName());

    public static Properties getProperties(final Class aClass, final String filename) {
        InputStream inputStream = aClass.getClassLoader().getResourceAsStream(filename);
        Properties properties = new Properties();

        try {
            properties.load(inputStream);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Problem with loading config file!\n{0}", ex.getMessage());
        }

        return properties;
    }

}
