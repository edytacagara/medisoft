/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.patient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import pl.medisoft.application.configuration.Configuration;
import pl.medisoft.application.configuration.ModuleEnum;
import pl.medisoft.application.identity.IdentityProvider;
import pl.medisoft.application.message.Messages;
import pl.medisoft.domain.user.User;
import pl.medisoft.infrastructure.user.UserDao;
import pl.medisoft.infrastructure.user.UserDaoJpa;
import pl.medisoft.ui.common.BaseFrame;

/**
 *
 * @author Kamil Ochnio
 */
public class PatientFrame extends BaseFrame {

    private final Messages messages = Messages.getInstace();
    private final String MODULE_NAME = messages.get(ModuleEnum.PATIENT.getMessageKey());
    private final JFrame parent;
    private User user;
    private UserDaoJpa userDaoJpa = new UserDaoJpa();
    public PatientFrame(final JFrame parent) {
        super(parent);
       this.parent = parent;

        setTitle(Configuration.TITLE + " " + Configuration.VERSION + " " + MODULE_NAME);
        initComponents();
        customize();

        setResizable(false);
    }

    @Override
    public void customize() {
        lblFirstName.setText(IdentityProvider.identity.getNameAndSurname());
         user = userDaoJpa.findByPesel(IdentityProvider.identity.getPesel());

        lblCity.setText(messages.get("app.user.city") + ":");
        lblCountry.setText(messages.get("app.user.country") + ":");
        lblEmail.setText(messages.get("app.user.email") + ":");
        lblHouseNumber.setText(messages.get("app.user.houseNumber") + ":");
        lblPesel.setText(messages.get("app.user.pesel") + ":");
        lblPostalCode.setText(messages.get("app.user.postalCode") + ":");
        lblStreet.setText(messages.get("app.user.street") + ":");
        //lblReservationHeader.setText(messages.get("app.patient.reservationHeader"));
        edtCity.setText(user.getCity());
        edtCountry.setText(user.getCountry());
        edtEmail.setText(user.getEmail());
        edtHouseNumber.setText(user.getHouseNumber());
        edtPostalCode.setText(user.getPostalCode());
        edtStreet.setText(user.getStreet());
        edtPesel.setText(user.getPesel());
        ((BaseFrame) parent).customize();

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPaneReservation = new javax.swing.JTabbedPane();
        panelPatientInfo = new javax.swing.JPanel();
        panel1 = new java.awt.Panel();
        lblFirstName = new java.awt.Label();
        lblPesel = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        lblPostalCode = new javax.swing.JLabel();
        lblCountry = new javax.swing.JLabel();
        lblStreet = new javax.swing.JLabel();
        lblHouseNumber = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        edtPesel = new javax.swing.JTextField();
        edtCity = new javax.swing.JTextField();
        edtPostalCode = new javax.swing.JTextField();
        edtCountry = new javax.swing.JTextField();
        edtStreet = new javax.swing.JTextField();
        edtHouseNumber = new javax.swing.JTextField();
        edtEmail = new javax.swing.JTextField();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        lblReklama = new java.awt.Label();
        panelEReservation = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        tabPaneReservation.setBackground(new java.awt.Color(153, 255, 255));
        tabPaneReservation.setFont(new java.awt.Font("Corbel", 0, 11)); // NOI18N

        panelPatientInfo.setBackground(new java.awt.Color(204, 255, 255));

        lblFirstName.setAlignment(java.awt.Label.CENTER);
        lblFirstName.setBackground(new java.awt.Color(153, 255, 255));
        lblFirstName.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        lblFirstName.setText("label1");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblPesel.setBackground(new java.awt.Color(153, 255, 255));
        lblPesel.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        lblPesel.setText("Pesel");
        lblPesel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblCity.setBackground(new java.awt.Color(153, 255, 255));
        lblCity.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        lblCity.setText("Miasto");
        lblCity.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblPostalCode.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        lblPostalCode.setText("Kod pocztowy");
        lblPostalCode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblCountry.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        lblCountry.setText("Kraj");
        lblCountry.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblStreet.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        lblStreet.setText("Ulica");
        lblStreet.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblHouseNumber.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        lblHouseNumber.setText("Numer domu");
        lblHouseNumber.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblEmail.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        lblEmail.setText("E-mail");
        lblEmail.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        edtPesel.setBackground(new java.awt.Color(153, 255, 255));
        edtPesel.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        edtPesel.setText("jTextField1");
        edtPesel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        edtCity.setEditable(false);
        edtCity.setBackground(new java.awt.Color(153, 255, 255));
        edtCity.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        edtCity.setText("jTextField1");
        edtCity.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        edtPostalCode.setEditable(false);
        edtPostalCode.setBackground(new java.awt.Color(153, 255, 255));
        edtPostalCode.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        edtPostalCode.setText("jTextField1");
        edtPostalCode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        edtCountry.setEditable(false);
        edtCountry.setBackground(new java.awt.Color(153, 255, 255));
        edtCountry.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        edtCountry.setText("jTextField1");
        edtCountry.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        edtStreet.setEditable(false);
        edtStreet.setBackground(new java.awt.Color(153, 255, 255));
        edtStreet.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        edtStreet.setText("jTextField1");
        edtStreet.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        edtHouseNumber.setEditable(false);
        edtHouseNumber.setBackground(new java.awt.Color(153, 255, 255));
        edtHouseNumber.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        edtHouseNumber.setText("jTextField1");
        edtHouseNumber.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        edtEmail.setEditable(false);
        edtEmail.setBackground(new java.awt.Color(153, 255, 255));
        edtEmail.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        edtEmail.setText("jTextField1");
        edtEmail.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnEdit.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        btnEdit.setText("Edytuj");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        btnSave.setText("Zapisz");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblReklama.setBackground(new java.awt.Color(153, 255, 255));
        lblReklama.setText("Miejsce na twoją reklamę. skontaktuj się z administracją");

        javax.swing.GroupLayout panelPatientInfoLayout = new javax.swing.GroupLayout(panelPatientInfo);
        panelPatientInfo.setLayout(panelPatientInfoLayout);
        panelPatientInfoLayout.setHorizontalGroup(
            panelPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPatientInfoLayout.createSequentialGroup()
                .addGroup(panelPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelPatientInfoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelPatientInfoLayout.createSequentialGroup()
                                .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edtEmail))
                            .addGroup(panelPatientInfoLayout.createSequentialGroup()
                                .addComponent(lblCity, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edtCity))
                            .addGroup(panelPatientInfoLayout.createSequentialGroup()
                                .addComponent(lblCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edtCountry))
                            .addGroup(panelPatientInfoLayout.createSequentialGroup()
                                .addComponent(lblPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edtPostalCode))
                            .addGroup(panelPatientInfoLayout.createSequentialGroup()
                                .addComponent(lblStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edtStreet))
                            .addGroup(panelPatientInfoLayout.createSequentialGroup()
                                .addComponent(lblHouseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edtHouseNumber))
                            .addGroup(panelPatientInfoLayout.createSequentialGroup()
                                .addComponent(lblPesel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edtPesel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelPatientInfoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave)))
                .addGap(70, 70, 70)
                .addComponent(lblReklama, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPatientInfoLayout.setVerticalGroup(
            panelPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPatientInfoLayout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPatientInfoLayout.createSequentialGroup()
                        .addGroup(panelPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPesel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtPesel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCity, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHouseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtHouseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblReklama, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnSave))
                .addGap(44, 44, 44))
        );

        tabPaneReservation.addTab("Dane o pacjencie", panelPatientInfo);

        panelEReservation.setBackground(new java.awt.Color(204, 255, 255));
        panelEReservation.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        panelEReservation.setPreferredSize(new java.awt.Dimension(385, 398));

        jLabel1.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel1.setText("W tym miejscu mogą Państwo zarezerwować wizyte");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jLabel2.setText("Proszę wybrać poradnię");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jLabel3.setText("Proszę wybrać poradnię");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jLabel4.setText("Proszę wybrać poradnię");
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jComboBox1.setBackground(new java.awt.Color(153, 255, 255));
        jComboBox1.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setBackground(new java.awt.Color(153, 255, 255));
        jComboBox2.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox3.setBackground(new java.awt.Color(153, 255, 255));
        jComboBox3.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jLabel5.setText("Proszę wybrać datę i godzinę");
        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelEReservationLayout = new javax.swing.GroupLayout(panelEReservation);
        panelEReservation.setLayout(panelEReservationLayout);
        panelEReservationLayout.setHorizontalGroup(
            panelEReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEReservationLayout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addGroup(panelEReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelEReservationLayout.createSequentialGroup()
                        .addGroup(panelEReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelEReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelEReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(132, 132, 132))
        );
        panelEReservationLayout.setVerticalGroup(
            panelEReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEReservationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(panelEReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(panelEReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(241, Short.MAX_VALUE))
        );

        tabPaneReservation.addTab("e-Rezerwacje", panelEReservation);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabPaneReservation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPaneReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        edtCity.setEditable(true);
        edtCountry.setEditable(true);
        edtEmail.setEditable(true);
        edtHouseNumber.setEditable(true);
        edtPostalCode.setEditable(true);
        edtStreet.setEditable(true);
        btnSave.setEnabled(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       
    }//GEN-LAST:event_btnSaveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JTextField edtCity;
    private javax.swing.JTextField edtCountry;
    private javax.swing.JTextField edtEmail;
    private javax.swing.JTextField edtHouseNumber;
    private javax.swing.JTextField edtPesel;
    private javax.swing.JTextField edtPostalCode;
    private javax.swing.JTextField edtStreet;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblEmail;
    private java.awt.Label lblFirstName;
    private javax.swing.JLabel lblHouseNumber;
    private javax.swing.JLabel lblPesel;
    private javax.swing.JLabel lblPostalCode;
    private java.awt.Label lblReklama;
    private javax.swing.JLabel lblStreet;
    private java.awt.Panel panel1;
    private javax.swing.JPanel panelEReservation;
    private javax.swing.JPanel panelPatientInfo;
    private javax.swing.JTabbedPane tabPaneReservation;
    // End of variables declaration//GEN-END:variables

   
}
