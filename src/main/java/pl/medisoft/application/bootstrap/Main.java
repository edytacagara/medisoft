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

    public static void main(String[] args) {
        ConfigurationLoader configurationLoader = new ConfigurationLoader();
        
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                final LoginFrame loginFrame = new LoginFrame(null);
            }
        });
    }

}
