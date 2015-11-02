/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.application.bootstrap;

import java.awt.EventQueue;
import javax.swing.JFrame;
import pl.medisoft.application.configuration.ConfigurationLoader;
import pl.medisoft.infrastructure.EntityManagerSingleton;
import pl.medisoft.ui.login.LoginFrame;

/**
 *
 * @author Mariusz Batyra
 */
public class Main {

    private static final ConfigurationLoader configurationLoader = new ConfigurationLoader();

    public static void main(String[] args) {
        EntityManagerSingleton.getInstance();
        
        EventQueue.invokeLater(() -> {
            final JFrame frame = new LoginFrame(null);
            frame.setVisible(true);
        });
    }

}
