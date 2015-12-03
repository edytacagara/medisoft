/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.admin.system;

import java.util.List;
import javax.swing.JComboBox;
import pl.medisoft.application.identity.IdentityProvider;
import pl.medisoft.application.message.Messages;
import pl.medisoft.domain.identity.Identity;
import pl.medisoft.domain.user.RoleDef;
import pl.medisoft.domain.user.User;
import pl.medisoft.domain.user.UsersRoles;
import pl.medisoft.infrastructure.adminsys.dao.UserRoleDaoFactory;
import pl.medisoft.infrastructure.adminsys.dao.UserRoleDao;
import pl.medisoft.infrastructure.user.UserDao;
import pl.medisoft.infrastructure.user.UserDaoJpa;

/**
 *
 * @author Rafal
 */
public class RoleEditPane extends javax.swing.JPanel {

    private Identity user = IdentityProvider.identity;
    private Messages messages;
    private List<RoleDef> availableRole;
    private List<UsersRoles> usersRoles;
    private List<User> users;
    private UserRoleDao userRoleDao = UserRoleDaoFactory.getUserRoleDao();
    private UserDao userDao = new UserDaoJpa();
    private int selectedToAdd = -1;
    private int selectedToRemove = -1;

    /**
     * Creates new form RoleEditPane
     */
    public RoleEditPane(Messages messages) {
        this.messages = messages;
        initComponents();
        this.getData(this.user.getId());
        this.setDataToComponents();
        this.setButtonVIsible();
    }

    private void getData(long userId) {
        this.availableRole = this.userRoleDao.getAvailableRolesByUserId(userId);
        this.usersRoles = this.userRoleDao.getUserRoleByUserId(userId);
        this.users = this.userDao.findAll();
    }

    private void setDataToComponents() {
        this.addDataToList(this.roleToAdd, this.availableRole);
        this.addDataToList(this.roleToRemove, this.usersRoles);
        this.addDataToCOmbo(this.usersComboBox, this.users);

    }

    private void addDataToCOmbo(JComboBox<User> comboBox, List<User> data) {
        for(User i : data) {
            comboBox.addItem(i);
        }
    }

    private void addDataToList(java.awt.List list, java.util.List data) {
        list.removeAll();
        for (int i = 0; i < data.size(); i++) {
            list.add(data.get(i).toString(), i);
        }
    }

    private void clearComponents() {
        this.usersRoles = null;
        this.availableRole = null;
        this.selectedToAdd = -1;
        this.selectedToRemove = -1;
    }

    private void setButtonVIsible() {
        this.addRoleButton.setEnabled((this.selectedToAdd != -1));
        this.removeRoleButton.setEnabled((this.selectedToRemove != -1));
    }

    private void refreshDataForUsers(User user) {
        this.clearComponents();
        this.usersRoles = this.userRoleDao.getUserRoleByUserId(user.getId());
        this.availableRole = this.userRoleDao.getAvailableRolesByUserId(user.getId());
        this.addDataToList(this.roleToAdd, this.availableRole);
        this.addDataToList(this.roleToRemove, this.usersRoles);
        this.setButtonVIsible();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        roleToAdd = new java.awt.List();
        roleToRemove = new java.awt.List();
        removeRoleButton = new java.awt.Button();
        addRoleButton = new java.awt.Button();
        usersComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        list1 = new java.awt.List();
        list2 = new java.awt.List();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();

        roleToAdd.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                roleToAddItemStateChanged(evt);
            }
        });

        roleToRemove.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                roleToRemoveItemStateChanged(evt);
            }
        });

        removeRoleButton.setLabel("<");
        removeRoleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeRoleButtonActionPerformed(evt);
            }
        });

        addRoleButton.setLabel(">");
        addRoleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoleButtonActionPerformed(evt);
            }
        });

        usersComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Uzytkownik");
        jLabel1.setToolTipText("");

        jLabel2.setText("Dodaj role");

        jLabel3.setText("Usuń role");

        jLabel4.setText("Dodaj uprawnienie");
        jLabel4.setToolTipText("");

        jLabel5.setText("Usuń uprawnienie");
        jLabel5.setToolTipText("");

        button1.setLabel(">");

        button2.setLabel("<");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roleToAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addRoleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeRoleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(roleToRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jSeparator1)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(list2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(usersComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usersComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(roleToRemove, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addComponent(roleToAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(addRoleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeRoleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(list2, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(list1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        removeRoleButton.getAccessibleContext().setAccessibleDescription("");
    }//GEN-END:initComponents

    private void addRoleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoleButtonActionPerformed
        RoleDef roleDef = this.availableRole.get(this.selectedToAdd);
        this.selectedToAdd = -1;
        this.userRoleDao.addRole(roleDef, ((User)this.usersComboBox.getSelectedItem()).getId());
        this.refreshDataForUsers((User)this.usersComboBox.getSelectedItem());
        
    }//GEN-LAST:event_addRoleButtonActionPerformed

    private void usersComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersComboBoxActionPerformed
        this.refreshDataForUsers((User) ((JComboBox) evt.getSource()).getSelectedItem());
    }//GEN-LAST:event_usersComboBoxActionPerformed

    private void roleToRemoveItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_roleToRemoveItemStateChanged
        this.selectedToRemove = ((java.awt.List) evt.getSource()).getSelectedIndex();
        if (this.selectedToAdd != -1) {
            this.roleToAdd.deselect(this.selectedToAdd);
            this.selectedToAdd = -1;
        }
        this.setButtonVIsible();
    }//GEN-LAST:event_roleToRemoveItemStateChanged

    private void roleToAddItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_roleToAddItemStateChanged
        this.selectedToAdd = ((java.awt.List) evt.getSource()).getSelectedIndex();
        if (this.selectedToRemove != -1) {
            this.roleToRemove.deselect(this.selectedToRemove);
            this.selectedToRemove = -1;
        }
        this.setButtonVIsible();
    }//GEN-LAST:event_roleToAddItemStateChanged

    private void removeRoleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRoleButtonActionPerformed
        UsersRoles usersRoles = this.usersRoles.get(this.selectedToRemove);
        this.selectedToRemove = -1;
        this.userRoleDao.removeRole(usersRoles);
        this.refreshDataForUsers((User)this.usersComboBox.getSelectedItem());
    }//GEN-LAST:event_removeRoleButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button addRoleButton;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private java.awt.List list1;
    private java.awt.List list2;
    private java.awt.Button removeRoleButton;
    private java.awt.List roleToAdd;
    private java.awt.List roleToRemove;
    private javax.swing.JComboBox<User> usersComboBox;
    // End of variables declaration//GEN-END:variables
}
