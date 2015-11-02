/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.common;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author Mariusz Batyra
 */
public abstract class BaseFrame extends JFrame {

    private JFrame parent = null;

    private BaseFrame() {

    }

    public BaseFrame(final JFrame parent) {
        super();
        this.parent = parent;
        if(parent != null) {
            parent.setVisible(false);
        }
        addWindowListener();
    }

    private void addWindowListener() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                if (parent != null) {
                    dispose();
                    parent.setVisible(true);
                } else {
                    System.exit(0);
                }
            }
        });
    }

}
