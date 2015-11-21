/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import pl.medisoft.ui.login.LoginFrame;

/**
 *
 * @author Mariusz Batyra
 */
public class MainFrame extends BaseFrame {

    private final IdentityProvider identityProvider = new IdentityProvider();
    private final Messages messages = Messages.getInstace();
    private final JFrame parent;
    
    public MainFrame(final JFrame parent) {
        super(parent);
        this.parent = parent;
        setTitle(Configuration.TITLE + " " + Configuration.VERSION);
        initComponents();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                if (parent != null) {
                    dispose();
                    identityProvider.logout();
                    parent.setVisible(true);
                } else {
                    System.exit(0);
                }
            }
        });
        btnPanel.setLayout(new GridLayout(ModuleEnum.values().length, 1));
        customize();
        setResizable(false);
    }

    private void drawButtons() {
        btnPanel.removeAll();
        List<RoleDef> userRoles = identityProvider.getUserRoles();
        if (userRoles != null) {
            for (RoleDef role : userRoles) {
                ModuleEnum module = ModuleEnum.fromRole(role.getId());
                if (module == null) {
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
        loginAsLabel.setText(messages.get("app.main.loginAs") + ":");
        menuLabel.setText(messages.get("app.main.menu") + ":");
        logoutButton.setText(messages.get("app.main.logout"));
        loginAsUserLabel.setText(IdentityProvider.identity.getNameAndSurname());
        ((BaseFrame) parent).customize();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPanel = new javax.swing.JPanel();
        loginAsLabel = new javax.swing.JLabel();
        loginAsUserLabel = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        menuLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        btnPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout btnPanelLayout = new javax.swing.GroupLayout(btnPanel);
        btnPanel.setLayout(btnPanelLayout);
        btnPanelLayout.setHorizontalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 222, Short.MAX_VALUE)
        );
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        loginAsLabel.setText("Jesteś zalogowany jako:");

        loginAsUserLabel.setText("User");

        logoutButton.setText("Wyloguj");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        menuLabel.setText("Menu:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loginAsUserLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loginAsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logoutButton))
                    .addComponent(menuLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginAsLabel)
                    .addComponent(logoutButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginAsUserLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(menuLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        dispose();
        identityProvider.logout();
        EventQueue.invokeLater(() -> {
            final JFrame frame = new LoginFrame(null);
            frame.setVisible(true);
        });
    }//GEN-LAST:event_logoutButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnPanel;
    private javax.swing.JLabel loginAsLabel;
    private javax.swing.JLabel loginAsUserLabel;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel menuLabel;
    // End of variables declaration//GEN-END:variables
}
