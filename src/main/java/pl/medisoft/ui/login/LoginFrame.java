/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.login;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import pl.medisoft.application.configuration.Configuration;
import pl.medisoft.ui.common.BaseFrame;

/**
 *
 * @author Mariusz Batyra
 */
public class LoginFrame extends JFrame implements BaseFrame {

    private final JFrame parent;
    
    public LoginFrame(final JFrame parent) {
        super(Configuration.TITLE + " " + Configuration.VERSION);
        this.parent = parent;
        initComponents();
        addWindowListener();
        setResizable(true);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public JFrame getParent() {
        return parent;
    }

    @Override
    public void addWindowListener() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                System.out.println("asss");
                if(parent != null) {
                    dispose();
                    parent.setVisible(true);
                }
                System.exit(0);
            }
        });
    }
    
}
