/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.admin.user;

import java.awt.EventQueue;
import javax.swing.JFrame;
import pl.medisoft.application.configuration.Configuration;
import pl.medisoft.application.configuration.ModuleEnum;
import pl.medisoft.application.message.Messages;
import pl.medisoft.ui.common.BaseFrame;

/**
 *
 * @author Mariusz Batyra
 */
public class UserAdminFrame extends BaseFrame {

    private final Messages messages = Messages.getInstace();
    private final String MODULE_NAME = messages.get(ModuleEnum.ADMIN_USER.getMessageKey());
    private final JFrame parent;
    
    public UserAdminFrame(final JFrame parent) {
        super(parent);
        this.parent = parent;
        setTitle(Configuration.TITLE + " " + Configuration.VERSION + " " + MODULE_NAME);
        initComponents();
        customize();
        setResizable(false);
    }

    @Override
    public void customize() {
        changeLangButton.setText(messages.get("app.lang.changeLang"));
        calendarButton.setText(messages.get("app.calendar.title"));
        ((BaseFrame) parent).customize();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        changeLangButton = new javax.swing.JButton();
        notesButton = new javax.swing.JButton();
        calendarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        changeLangButton.setText("Zmień język");
        changeLangButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeLangButtonActionPerformed(evt);
            }
        });

        notesButton.setText("Notatki");
        notesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notesButtonActionPerformed(evt);
            }
        });

        calendarButton.setText("Kalendarz");
        calendarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calendarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(changeLangButton, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(notesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(calendarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(changeLangButton)
                .addGap(18, 18, 18)
                .addComponent(notesButton)
                .addGap(18, 18, 18)
                .addComponent(calendarButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void changeLangButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeLangButtonActionPerformed
        EventQueue.invokeLater(() -> {
            JFrame frame = new LanguageFrame(this);
            frame.setVisible(true);
        });
    }//GEN-LAST:event_changeLangButtonActionPerformed

    private void notesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notesButtonActionPerformed
        EventQueue.invokeLater(() -> {
            JFrame frame = new NotesFrame(this);
            frame.setVisible(true);
        });
    }//GEN-LAST:event_notesButtonActionPerformed

    private void calendarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calendarButtonActionPerformed
         EventQueue.invokeLater(() -> {
            JFrame frame = new CalendarFrame(this);
            frame.setVisible(true);
        });
    }//GEN-LAST:event_calendarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calendarButton;
    private javax.swing.JButton changeLangButton;
    private javax.swing.JButton notesButton;
    // End of variables declaration//GEN-END:variables

}
