/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.admin.clinic;

import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JFrame;
import pl.medisoft.application.common.StringsUtils;
import pl.medisoft.application.configuration.Configuration;
import pl.medisoft.application.configuration.ModuleEnum;
import pl.medisoft.application.message.Messages;
import pl.medisoft.domain.admin.clinic.EmploymentReq;
import pl.medisoft.domain.user.RoleDef;
import pl.medisoft.domain.user.User;
import pl.medisoft.domain.user.UsersDetails;
import pl.medisoft.infrastructure.admin.clinic.EmploymentReqDao;
import pl.medisoft.infrastructure.admin.clinic.EmploymentReqDaoJpa;
import pl.medisoft.infrastructure.user.UserDao;
import pl.medisoft.infrastructure.user.UserDaoJpa;
import pl.medisoft.ui.common.BaseFrame;

/**
 *
 * @author Edyta Cagara
 */
public class ClinicAdminFrame extends BaseFrame {
    
    private final Messages messages = Messages.getInstace();
    private final String MODULE_NAME = messages.get(ModuleEnum.ADMIN_CLINIC.getMessageKey());
    private User currentEmployee;

    public ClinicAdminFrame(final JFrame parent) {
        super(parent);
        setTitle(Configuration.TITLE + " " + Configuration.VERSION + " " + MODULE_NAME);
        initComponents();

        if(employeeSelectComboBox.getItemCount() > 0)
            employeeSelectComboBox.setSelectedIndex(0);
        if(employmentRoleComboBox.getItemCount() > 0)
        employmentRoleComboBox.setSelectedIndex(0);
        
        currentEmployee = null;
        
        setResizable(false);
    }

    @Override
    public void customize() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel5 = new javax.swing.JPanel();
        employeeSelectComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        employeeNameTextField = new javax.swing.JTextField();
        employeeSurnameTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        employeeBonusTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        employeeContractComboBox = new javax.swing.JComboBox();
        addEmployeeButton = new javax.swing.JButton();
        removeEmployeeButton = new javax.swing.JButton();
        saveEmployeeButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        employeeRoleList = new javax.swing.JList();
        employeeSalaryTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        employeeWorktimeTextField = new javax.swing.JTextField();
        employeePeselTextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        employmentRoleComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        employmentWorkTimeTextField = new javax.swing.JTextField();
        employmentSalaryBaseTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        unassignedWorkTimeTextField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1077, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 537, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Telefoniczna rejestracja pacjentow", jPanel1);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jSplitPane1.setDividerLocation(400);

        employeeSelectComboBox.setModel(new EmployeeComboBoxModel());
        employeeSelectComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeSelectComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setText("Pracownik");

        jLabel4.setText("Imie");

        jLabel5.setText("Nazwisko");

        jLabel7.setText("Funkcja");

        jLabel8.setText("Wymiar pracy");

        jLabel9.setText("Premia (%)");

        employeeBonusTextField.setText("0");

        jLabel10.setText("Rodzaj umowy");

        employeeContractComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        addEmployeeButton.setText("Dodaj nowego pracownika");
        addEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeButtonActionPerformed(evt);
            }
        });

        removeEmployeeButton.setText("Usun pracownika");

        saveEmployeeButton.setText("Zapisz");
        saveEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveEmployeeButtonActionPerformed(evt);
            }
        });

        employeeRoleList.setModel(new UserRoleListModel());
        jScrollPane2.setViewportView(employeeRoleList);

        employeeSalaryTextField.setText("0");

        jLabel12.setText("Pensja");

        employeeWorktimeTextField.setText("0");

        jLabel13.setText("PESEL");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(addEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeEmployeeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(saveEmployeeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(employeePeselTextField)
                            .addComponent(employeeSalaryTextField)
                            .addComponent(employeeBonusTextField)
                            .addComponent(employeeContractComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(employeeSurnameTextField)
                            .addComponent(employeeNameTextField)
                            .addComponent(employeeSelectComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(employeeWorktimeTextField))))
                .addGap(194, 194, 194))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeSelectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(employeeNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeSurnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeePeselTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeWorktimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeContractComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeBonusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeSalaryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEmployeeButton)
                    .addComponent(removeEmployeeButton))
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(jPanel5);

        jLabel1.setText("Funkcja pracownika");

        employmentRoleComboBox.setModel(new EmploymentRoleComboBoxModel());
        employmentRoleComboBox.setSelectedIndex(0);
        employmentRoleComboBox.setToolTipText("");
        employmentRoleComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employmentRoleComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Wymagana liczba roboczogodzin");

        employmentWorkTimeTextField.setText("0");

        employmentSalaryBaseTextField.setText("0");

        jLabel6.setText("Podstawa pensji");

        jLabel11.setText("Brakująca liczba roboczogodzin (wakaty)");

        unassignedWorkTimeTextField.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(employmentSalaryBaseTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                            .addComponent(employmentRoleComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(employmentWorkTimeTextField)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(unassignedWorkTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(employmentRoleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(employmentWorkTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employmentSalaryBaseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(unassignedWorkTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(398, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(jPanel6);

        jPanel2.add(jSplitPane1);

        jTabbedPane1.addTab("Zarzadzanie pracownikami", jPanel2);

        jTable1.setModel(new StockTableModel());
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1057, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inwentaryzacja", jPanel3);

        getContentPane().add(jTabbedPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void employeeSelectComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeSelectComboBoxActionPerformed

        if(employeeSelectComboBox.getSelectedIndex() == -1){
            employeeNameTextField.setText("");
            employeeSurnameTextField.setText("");
            employeePeselTextField.setText("");
        }
        else{
            User user = (User)employeeSelectComboBox.getSelectedItem();
            EmploymentReqDao employmentReqDao = new EmploymentReqDaoJpa();
            List<EmploymentReq> employmentReqs = employmentReqDao.findAll();
            this.currentEmployee = user;
            UsersDetails userDetails = user.getUsersDetails();
            List<RoleDef> userRoles = user.getUserRoles();
            
            employeeRoleList.setListData(employmentReqs.toArray());
            int[] selectedIndices = new int[userRoles.size()];
            
            for(int i=0; i<userRoles.size(); i++){
                for(int k=0;k<employmentReqs.size();k++){
                    if(employmentReqs.get(k).getRoleDef().equals(userRoles.get(i)))
                        selectedIndices[i] = k;
                }
            }
            employeeRoleList.setSelectedIndices(selectedIndices);
            
            employeeNameTextField.setText(user.getName());
            employeeSurnameTextField.setText(user.getSurname());
            employeePeselTextField.setText(user.getPesel());

            int totalSalary = 0;
            if(userDetails != null){
                
                
                for(int i=0;i<employmentReqs.size();i++){
                    if(userRoles.contains(employmentReqs.get(i).getRoleDef())){
                        int salaryBase = employmentReqs.get(i).getSalaryBase().intValue();
                        int workTime = userDetails.getWorkTime().intValue();
                        totalSalary += workTime * salaryBase;
                    }
                }

                int bonus = userDetails.getBonus().intValue();
                int salaryWithBonus = (int)Math.round(totalSalary*(100+bonus)/100.0);
                employeeWorktimeTextField.setText(userDetails.getWorkTime().toString());
                employeeBonusTextField.setText(Integer.toString(bonus) + "%");
                employeeSalaryTextField.setText(Integer.toString(salaryWithBonus));
            }
            else{
                employeeWorktimeTextField.setText("brak danych");
                employeeBonusTextField.setText("brak danych");
                employeeSalaryTextField.setText("brak danych");
            }
        }
    }//GEN-LAST:event_employeeSelectComboBoxActionPerformed

    private void employmentRoleComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employmentRoleComboBoxActionPerformed
        EmploymentReq employmentReq = (EmploymentReq)employmentRoleComboBox.getSelectedItem();
        employmentWorkTimeTextField.setText(employmentReq.getWorktimeReq().toString());
        employmentSalaryBaseTextField.setText(employmentReq.getSalaryBase().toString());
        
        // Compute unassigned worktime for user role
        int totalWorktime = 0;
        RoleDef roleDef = employmentReq.getRoleDef();
        UserDao userDao = new UserDaoJpa();
        Iterator<User> i = userDao.findAll().iterator();
        while(i.hasNext()){
            User user = i.next();
            if(user.getUserRoles().contains(roleDef)){
                UsersDetails userDetails = user.getUsersDetails();
                if(userDetails != null && userDetails.getWorkTime() != null)
                    totalWorktime += userDetails.getWorkTime();
            }
        }
        
        unassignedWorkTimeTextField.setText(Integer.toString(employmentReq.getWorktimeReq().intValue()-totalWorktime));
    }//GEN-LAST:event_employmentRoleComboBoxActionPerformed

    private void addEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeButtonActionPerformed
        this.currentEmployee = null;
        this.employeeSelectComboBox.setSelectedIndex(-1);
    }//GEN-LAST:event_addEmployeeButtonActionPerformed

    private void saveEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveEmployeeButtonActionPerformed
        if(this.currentEmployee == null){
            this.currentEmployee = new User();
            this.currentEmployee.setName(this.employeeNameTextField.getText());
            this.currentEmployee.setSurname(this.employeeSurnameTextField.getText());
            this.currentEmployee.setPesel(this.employeePeselTextField.getText());
            
            String username = this.employeeNameTextField.getText().toLowerCase().substring(0,1) +
                    this.employeeSurnameTextField.getText().toLowerCase();
            
            this.currentEmployee.setUsername(username);
            this.currentEmployee.setPasshash(StringsUtils.generateSHA256(username));
            List<RoleDef> userRoles = this.employeeRoleList.getSelectedValuesList();
            this.currentEmployee.setUserRoles(userRoles);
            
            new UserDaoJpa().addUser(currentEmployee);
            this.employeeSelectComboBox.setModel(new EmployeeComboBoxModel());
            this.employeeSelectComboBox.validate();
        }
    }//GEN-LAST:event_saveEmployeeButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEmployeeButton;
    private javax.swing.JTextField employeeBonusTextField;
    private javax.swing.JComboBox employeeContractComboBox;
    private javax.swing.JTextField employeeNameTextField;
    private javax.swing.JTextField employeePeselTextField;
    private javax.swing.JList employeeRoleList;
    private javax.swing.JTextField employeeSalaryTextField;
    private javax.swing.JComboBox employeeSelectComboBox;
    private javax.swing.JTextField employeeSurnameTextField;
    private javax.swing.JTextField employeeWorktimeTextField;
    private javax.swing.JComboBox employmentRoleComboBox;
    private javax.swing.JTextField employmentSalaryBaseTextField;
    private javax.swing.JTextField employmentWorkTimeTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton removeEmployeeButton;
    private javax.swing.JButton saveEmployeeButton;
    private javax.swing.JTextField unassignedWorkTimeTextField;
    // End of variables declaration//GEN-END:variables

}
