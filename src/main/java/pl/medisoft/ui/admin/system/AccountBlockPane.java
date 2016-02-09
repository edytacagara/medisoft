/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.admin.system;

import java.util.List;
import javax.swing.JComboBox;
import pl.medisoft.application.message.Messages;
import pl.medisoft.domain.user.User;
import pl.medisoft.infrastructure.user.UserDao;
import pl.medisoft.infrastructure.user.UserDaoJpa;

/**
 *
 * @author Rafal
 */
public class AccountBlockPane extends javax.swing.JPanel {

    private UserDao userDao = new UserDaoJpa();
    private Messages messages;
    private List<User> users;
    private User selectedUser;
    
    public AccountBlockPane(Messages messages) {
        this.messages = messages;
        initComponents();
        getData();
    }
    
    
    private void getData(){
        this.users = this.userDao.findAll();
        this.selectedUser = this.users.get(0);
        this.addDataToCOmbo(userComboBox, users);
        this.setUserLockCheckBox(this.selectedUser);
    }
    
    private void setUserLockCheckBox(User user){
        this.userLockCheckBox.setSelected((user.getIsLock() == 1));
    }
    
    private void addDataToCOmbo(JComboBox<User> comboBox, List<User> data) {
        for(User i : data) {
            comboBox.addItem(i);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        userComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        userLockCheckBox = new javax.swing.JCheckBox();

        userComboBox.setSelectedIndex(-1);
        userComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Użytkownik:");

        userLockCheckBox.setText("Zablokuj użytkownika");
        userLockCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userLockCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(userComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(userLockCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(43, 43, 43)
                .addComponent(userLockCheckBox)
                .addContainerGap(242, Short.MAX_VALUE))
        );
    }//GEN-END:initComponents

    private void userComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userComboBoxActionPerformed
        this.selectedUser = (User) ((JComboBox) evt.getSource()).getSelectedItem();
        this.setUserLockCheckBox(this.selectedUser);
    }//GEN-LAST:event_userComboBoxActionPerformed

    private void userLockCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userLockCheckBoxActionPerformed
        this.selectedUser.setIsLock(this.userLockCheckBox.isSelected() ? 1 : 0);
        this.userDao.updateUser(this.selectedUser);
    }//GEN-LAST:event_userLockCheckBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<User> userComboBox;
    private javax.swing.JCheckBox userLockCheckBox;
    // End of variables declaration//GEN-END:variables
}
