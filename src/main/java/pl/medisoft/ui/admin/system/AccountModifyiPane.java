/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.admin.system;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import pl.medisoft.application.message.Messages;
import pl.medisoft.domain.user.User;
import pl.medisoft.infrastructure.adminsys.model.UserTableModel;
import pl.medisoft.infrastructure.user.UserDao;
import pl.medisoft.infrastructure.user.UserDaoJpa;
import pl.medisoft.infrastructure.adminsys.model.modelinterface.UserSaveInterface;

/**
 *
 * @author Rafal
 */
public class AccountModifyiPane extends javax.swing.JPanel implements UserSaveInterface{

    private UserDao userDao = new UserDaoJpa();
    private List<User> users;
    private Messages messages;

    /**
     * Creates new form AccountModyfiPane
     */
    public AccountModifyiPane(Messages messages) {
        this.messages = messages;
        this.getData();
        initComponents();
        this.setDataToComponents();
    }

    private void getData() {
        this.users = this.userDao.findAll();

    }

    private AbstractTableModel getTableModel() {
        return new UserTableModel(this.users,this.userDao,this);
    }
    
    private void setDataToComponents(){
        this.jTable2.setModel(this.getTableModel());
    }

    private void saveData() {
        ((UserTableModel)this.jTable2.getModel()).saveData();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        saveButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        saveButton.setText("Zapisz zmiany");
        saveButton.setEnabled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(saveButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(saveButton)
                .addContainerGap(68, Short.MAX_VALUE))
        );
    }//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        this.saveData();
        this.saveButton.setEnabled(false);
    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void buttonActrive() {
        this.saveButton.setEnabled(true);
    }
}
