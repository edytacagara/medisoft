/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.application.bootstrap;

import java.awt.EventQueue;
import pl.medisoft.application.configuration.ConfigurationLoader;
import pl.medisoft.ui.login.LoginFrame;

/**
 *
 * @author Mariusz Batyra
 */
public class Main {

    private static final ConfigurationLoader configurationLoader = new ConfigurationLoader();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            final LoginFrame loginFrame = new LoginFrame(null);
        });
    }

}
