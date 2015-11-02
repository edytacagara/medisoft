/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import pl.medisoft.application.configuration.Configuration;
import pl.medisoft.ui.admin.clinic.ClinicAdminFrame;
import pl.medisoft.ui.admin.system.SysAdminFrame;
import pl.medisoft.ui.admin.user.UserAdminFrame;
import pl.medisoft.ui.common.BaseFrame;
import pl.medisoft.ui.doctor.DoctorFrame;
import pl.medisoft.ui.login.LoginFrame;
import pl.medisoft.ui.patient.PatientFrame;
import pl.medisoft.ui.pharmacy.PharmacyFrame;

/**
 *
 * @author Mariusz Batyra
 */
public class MainFrame extends BaseFrame {

    public MainFrame(final JFrame parent) {
        super(parent);
        setTitle(Configuration.TITLE + " " + Configuration.VERSION);
        initComponents();

        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sysAdminButton = new javax.swing.JButton();
        userAdminButton = new javax.swing.JButton();
        clinicAdminButton = new javax.swing.JButton();
        doctorButton = new javax.swing.JButton();
        patientButton = new javax.swing.JButton();
        pharmacyButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        sysAdminButton.setText("Administracja systemu");
        sysAdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sysAdminButtonActionPerformed(evt);
            }
        });

        userAdminButton.setText("Użytkownik");
        userAdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userAdminButtonActionPerformed(evt);
            }
        });

        clinicAdminButton.setText("Administracja przychodni");
        clinicAdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clinicAdminButtonActionPerformed(evt);
            }
        });

        doctorButton.setText("Panel lekarza");
        doctorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorButtonActionPerformed(evt);
            }
        });

        patientButton.setText("Panel pacjenta");
        patientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientButtonActionPerformed(evt);
            }
        });

        pharmacyButton.setText("Panel apteka");
        pharmacyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pharmacyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sysAdminButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userAdminButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clinicAdminButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(doctorButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pharmacyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sysAdminButton)
                .addGap(18, 18, 18)
                .addComponent(userAdminButton)
                .addGap(18, 18, 18)
                .addComponent(clinicAdminButton)
                .addGap(18, 18, 18)
                .addComponent(doctorButton)
                .addGap(18, 18, 18)
                .addComponent(patientButton)
                .addGap(18, 18, 18)
                .addComponent(pharmacyButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sysAdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sysAdminButtonActionPerformed
        EventQueue.invokeLater(() -> {
            final JFrame frame = new SysAdminFrame(this);
            frame.setVisible(true);
        });
    }//GEN-LAST:event_sysAdminButtonActionPerformed

    private void userAdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userAdminButtonActionPerformed
        EventQueue.invokeLater(() -> {
            final JFrame frame = new UserAdminFrame(this);
            frame.setVisible(true);
        });
    }//GEN-LAST:event_userAdminButtonActionPerformed

    private void clinicAdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clinicAdminButtonActionPerformed
        EventQueue.invokeLater(() -> {
            final JFrame frame = new ClinicAdminFrame(this);
            frame.setVisible(true);
        });
    }//GEN-LAST:event_clinicAdminButtonActionPerformed

    private void doctorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorButtonActionPerformed
        EventQueue.invokeLater(() -> {
            final JFrame frame = new DoctorFrame(this);
            frame.setVisible(true);
        });
    }//GEN-LAST:event_doctorButtonActionPerformed

    private void patientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientButtonActionPerformed
        EventQueue.invokeLater(() -> {
            final JFrame frame = new PatientFrame(this);
            frame.setVisible(true);
        });
    }//GEN-LAST:event_patientButtonActionPerformed

    private void pharmacyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pharmacyButtonActionPerformed
        EventQueue.invokeLater(() -> {
            final JFrame frame = new PharmacyFrame(this);
            frame.setVisible(true);
        });
    }//GEN-LAST:event_pharmacyButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clinicAdminButton;
    private javax.swing.JButton doctorButton;
    private javax.swing.JButton patientButton;
    private javax.swing.JButton pharmacyButton;
    private javax.swing.JButton sysAdminButton;
    private javax.swing.JButton userAdminButton;
    // End of variables declaration//GEN-END:variables
}
