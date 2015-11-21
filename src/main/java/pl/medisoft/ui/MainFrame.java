/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import pl.medisoft.application.configuration.Configuration;
import pl.medisoft.application.configuration.ModuleEnum;
import pl.medisoft.application.identity.IdentityProvider;
import pl.medisoft.application.message.Messages;
import pl.medisoft.domain.user.RoleDef;
import pl.medisoft.ui.common.BaseFrame;

/**
 *
 * @author Mariusz Batyra
 */
public class MainFrame extends BaseFrame {

    private final IdentityProvider identityProvider = new IdentityProvider();
    private final Messages messages = Messages.getInstace();
    
    public MainFrame(final JFrame parent) {
        super(parent);
        setTitle(Configuration.TITLE + " " + Configuration.VERSION);
        initComponents();
        btnPanel.setLayout(new GridLayout(ModuleEnum.values().length, 1));
        customize();
        setResizable(false);
    }
    
    private void drawButtons() {
        btnPanel.removeAll();
        List<RoleDef> userRoles = identityProvider.getUserRoles();
        if(userRoles != null) {
            for(RoleDef role : userRoles) {
                ModuleEnum module = ModuleEnum.fromRole(role.getId());
                if(module == null) {
                    continue;
                }
                final JButton btn = new JButton(messages.get(module.getMessageKey()));
                btn.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            Constructor constructor = module.getClazz().getConstructor(JFrame.class);
                            JFrame frame = (JFrame) constructor.newInstance(getThis());
                            frame.setVisible(true);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                btnPanel.add(btn);
                btnPanel.validate();
                btnPanel.repaint();
                repaint();
            }
        }
    }

    private JFrame getThis() {
        return this;
    }
    
    @Override
    public void customize() {
        drawButtons();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        javax.swing.GroupLayout btnPanelLayout = new javax.swing.GroupLayout(btnPanel);
        btnPanel.setLayout(btnPanelLayout);
        btnPanelLayout.setHorizontalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 228, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnPanel;
    // End of variables declaration//GEN-END:variables
}
