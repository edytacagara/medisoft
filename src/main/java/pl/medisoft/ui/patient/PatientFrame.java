/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.patient;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import pl.medisoft.application.configuration.Configuration;
import pl.medisoft.application.configuration.ModuleEnum;
import pl.medisoft.application.identity.IdentityProvider;
import pl.medisoft.application.message.Messages;
import pl.medisoft.domain.Patient.VisitType;
import pl.medisoft.domain.user.User;
import pl.medisoft.infrastructure.visit.VisitDaoJpa;
import pl.medisoft.infrastructure.user.UserDaoJpa;
import pl.medisoft.ui.common.BaseFrame;
import pl.medisoft.ui.doctor.Doctor;
import java.util.Calendar;
import java.util.Date;
import javafx.scene.chart.PieChart;
import pl.medisoft.domain.Patient.Visit;
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
    private List<VisitType> visitTypes;
    private List<Doctor> doctors = new ArrayList();
    private VisitDaoJpa visitDaoJpa = new VisitDaoJpa();
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;
    private static final String MONTH_MSG_PREFIX = "app.calendar.month";
    private static final int[] NUMBER_OF_DAY = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String PREFIX = "app.calendar.";
    private Doctor doctor;
    private VisitType visitType;
    private Visit visit;
    private Date visitDate = new Date();

    
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
        user = userDaoJpa.findById(IdentityProvider.identity.getId());

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
        initDateComboBox();
        setToday();
        this.getData();
        this.setDataToComponents();

    }

    private void getData() {
        this.visitTypes = this.visitDaoJpa.findAllVisitType();
        entityManagerFactory = Persistence.createEntityManagerFactory("MediSoftPU");
        entityManager = entityManagerFactory.createEntityManager();        //entityManager=Persistence.createEntityManagerFactory("MediSoftPU").createEntityManager()
        doctors = entityManager.createQuery("SELECT d FROM Doctor d").getResultList();;
    }

    private void setDataToComponents() {
        this.addVisitTypeToComboBox(this.jComboBoxRodzajZabiegu1, this.visitTypes);
        this.addDoctorComboBox(this.jComboBoxWyborLekarza, doctors);

    }

    private void addVisitTypeToComboBox(JComboBox<VisitType> jComboBoxRodzajZabiegu1, List<VisitType> visitTypes) {
        for (VisitType i : visitTypes) {
            this.jComboBoxRodzajZabiegu1.addItem(i);
        }
    }

    private void addDoctorComboBox(JComboBox<Doctor> jComboBox, List<Doctor> doctors) {
        for (Doctor i : doctors) {
            jComboBox.addItem(i);
        }
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
        cbMonth = new javax.swing.JComboBox<>();
        jComboBoxWyborLekarza = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxRodzajZabiegu1 = new javax.swing.JComboBox<>();
        cbYear = new javax.swing.JComboBox<>();
        cbHour = new javax.swing.JComboBox<>();
        cbDay = new javax.swing.JComboBox<>();
        btnAddVisit = new java.awt.Button();
        label1 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        tabPaneReservation.setBackground(new java.awt.Color(153, 255, 255));
        tabPaneReservation.setFont(new java.awt.Font("Corbel", 0, 11)); // NOI18N

        panelPatientInfo.setBackground(new java.awt.Color(255, 255, 255));

        lblFirstName.setAlignment(java.awt.Label.CENTER);
        lblFirstName.setBackground(new java.awt.Color(255, 255, 255));
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

        lblCity.setBackground(new java.awt.Color(153, 255, 255));
        lblCity.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        lblCity.setText("Miasto");

        lblPostalCode.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        lblPostalCode.setText("Kod pocztowy");

        lblCountry.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        lblCountry.setText("Kraj");

        lblStreet.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        lblStreet.setText("Ulica");

        lblHouseNumber.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        lblHouseNumber.setText("Numer domu");

        lblEmail.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        lblEmail.setText("E-mail");

        edtPesel.setEditable(false);
        edtPesel.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        edtPesel.setText("jTextField1");
        edtPesel.setBorder(null);

        edtCity.setEditable(false);
        edtCity.setBackground(new java.awt.Color(255, 255, 255));
        edtCity.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        edtCity.setText("jTextField1");
        edtCity.setBorder(null);

        edtPostalCode.setEditable(false);
        edtPostalCode.setBackground(new java.awt.Color(255, 255, 255));
        edtPostalCode.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        edtPostalCode.setText("jTextField1");
        edtPostalCode.setBorder(null);

        edtCountry.setEditable(false);
        edtCountry.setBackground(new java.awt.Color(255, 255, 255));
        edtCountry.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        edtCountry.setText("jTextField1");
        edtCountry.setBorder(null);

        edtStreet.setEditable(false);
        edtStreet.setBackground(new java.awt.Color(255, 255, 255));
        edtStreet.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        edtStreet.setText("jTextField1");
        edtStreet.setBorder(null);

        edtHouseNumber.setEditable(false);
        edtHouseNumber.setBackground(new java.awt.Color(255, 255, 255));
        edtHouseNumber.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        edtHouseNumber.setText("jTextField1");
        edtHouseNumber.setBorder(null);

        edtEmail.setEditable(false);
        edtEmail.setBackground(new java.awt.Color(255, 255, 255));
        edtEmail.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        edtEmail.setText("jTextField1");
        edtEmail.setBorder(null);

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

        panelEReservation.setBackground(new java.awt.Color(255, 255, 255));
        panelEReservation.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        panelEReservation.setPreferredSize(new java.awt.Dimension(385, 398));

        jLabel1.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel1.setText("Szukaj badania/zabiegu lub lekarza");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        cbMonth.setBackground(new java.awt.Color(153, 255, 255));
        cbMonth.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        cbMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMonthActionPerformed(evt);
            }
        });

        jComboBoxWyborLekarza.setBackground(new java.awt.Color(153, 255, 255));
        jComboBoxWyborLekarza.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jComboBoxWyborLekarza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxWyborLekarzaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jLabel5.setText("Wybierz termin wizyty");

        jComboBoxRodzajZabiegu1.setBackground(new java.awt.Color(153, 255, 255));
        jComboBoxRodzajZabiegu1.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jComboBoxRodzajZabiegu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRodzajZabiegu1ActionPerformed(evt);
            }
        });

        cbYear.setBackground(new java.awt.Color(153, 255, 255));
        cbYear.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        cbYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbYearActionPerformed(evt);
            }
        });

        cbHour.setBackground(new java.awt.Color(153, 255, 255));
        cbHour.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        cbHour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHourActionPerformed(evt);
            }
        });

        cbDay.setBackground(new java.awt.Color(153, 255, 255));
        cbDay.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        cbDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDayActionPerformed(evt);
            }
        });

        btnAddVisit.setLabel("button1");
        btnAddVisit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVisitActionPerformed(evt);
            }
        });

        label1.setText("label1");

        javax.swing.GroupLayout panelEReservationLayout = new javax.swing.GroupLayout(panelEReservation);
        panelEReservation.setLayout(panelEReservationLayout);
        panelEReservationLayout.setHorizontalGroup(
            panelEReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEReservationLayout.createSequentialGroup()
                .addGap(0, 77, Short.MAX_VALUE)
                .addGroup(panelEReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelEReservationLayout.createSequentialGroup()
                            .addGap(87, 87, 87)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelEReservationLayout.createSequentialGroup()
                            .addGroup(panelEReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelEReservationLayout.createSequentialGroup()
                                    .addComponent(cbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbMonth, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jComboBoxRodzajZabiegu1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(panelEReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBoxWyborLekarza, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelEReservationLayout.createSequentialGroup()
                                    .addComponent(cbDay, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbHour, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(panelEReservationLayout.createSequentialGroup()
                            .addGap(190, 190, 190)
                            .addComponent(btnAddVisit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(label1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );
        panelEReservationLayout.setVerticalGroup(
            panelEReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEReservationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(panelEReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxWyborLekarza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxRodzajZabiegu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addGap(27, 27, 27)
                .addGroup(panelEReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(btnAddVisit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jLabel1.getAccessibleContext().setAccessibleName("lblErezerwacjeTytul");
        cbMonth.getAccessibleContext().setAccessibleName("");
        jComboBoxWyborLekarza.getAccessibleContext().setAccessibleName("cbWyborLekarza");
        jLabel5.getAccessibleContext().setAccessibleName("lblTerminWizyty");
        btnAddVisit.getAccessibleContext().setAccessibleName("Rezerwuj");

        tabPaneReservation.addTab("e-Rezerwacje", panelEReservation);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPaneReservation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabPaneReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
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

    private void cbMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMonthActionPerformed
        visitDate.setMonth(cbMonth.getSelectedIndex());
    }//GEN-LAST:event_cbMonthActionPerformed

    private void jComboBoxWyborLekarzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxWyborLekarzaActionPerformed
        if (jComboBoxWyborLekarza.getSelectedIndex() == -1) {

        } else {
             doctor = (Doctor) jComboBoxWyborLekarza.getSelectedItem();
        }
    }//GEN-LAST:event_jComboBoxWyborLekarzaActionPerformed

    private void jComboBoxRodzajZabiegu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRodzajZabiegu1ActionPerformed
        if(jComboBoxRodzajZabiegu1.getSelectedIndex()==-1){
            
        }else{
            visitType=(VisitType)jComboBoxRodzajZabiegu1.getSelectedItem();
        }            
    }//GEN-LAST:event_jComboBoxRodzajZabiegu1ActionPerformed

    private void cbYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbYearActionPerformed
         visitDate.setYear(2016-1900+cbYear.getSelectedIndex());
    }//GEN-LAST:event_cbYearActionPerformed

    private void cbHourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHourActionPerformed
        visitDate.setHours(cbHour.getSelectedIndex());
    }//GEN-LAST:event_cbHourActionPerformed

    private void cbDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDayActionPerformed
       visitDate.setDate(cbDay.getSelectedIndex()+1);
    }//GEN-LAST:event_cbDayActionPerformed

    private void btnAddVisitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVisitActionPerformed
         visit=new Visit();
         visit.setDoctor(doctor);
         visit.setPatient(user);
         visit.setVisitType(visitType);
         visit.setVisitDate(visitDate);
         visitDaoJpa.addVisit(visit);
         label1.setText(visitDate.toString());
    }//GEN-LAST:event_btnAddVisitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnAddVisit;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cbDay;
    private javax.swing.JComboBox cbHour;
    private javax.swing.JComboBox cbMonth;
    private javax.swing.JComboBox cbYear;
    private javax.swing.JTextField edtCity;
    private javax.swing.JTextField edtCountry;
    private javax.swing.JTextField edtEmail;
    private javax.swing.JTextField edtHouseNumber;
    private javax.swing.JTextField edtPesel;
    private javax.swing.JTextField edtPostalCode;
    private javax.swing.JTextField edtStreet;
    private javax.swing.JComboBox<VisitType> jComboBoxRodzajZabiegu1;
    private javax.swing.JComboBox<Doctor> jComboBoxWyborLekarza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private java.awt.Label label1;
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

    private void initDateComboBox() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);        
        int month = cal.get(Calendar.MONTH);        
        int day = cal.get(Calendar.DATE);        
        int Hour = cal.get(Calendar.HOUR_OF_DAY);    
        //int minute = cal.get(Calendar.MINUTE);    

        cbYear.removeAllItems();
        for (int i = 0; i < 10; i++) {
            cbYear.addItem(String.valueOf(year+i));
        }
        cbYear.setSelectedIndex(0);
        
        cbMonth.removeAllItems();
        for (int i = 0; i < 12; i++) {
            String monthNameKey = MONTH_MSG_PREFIX + String.valueOf(i + 1);
            cbMonth.addItem(messages.get(monthNameKey));
        }
        cbMonth.setSelectedIndex(month);
        
        cbDay.removeAllItems();
        int selectedIndex = cbMonth.getSelectedIndex();
        int numberOfDay = NUMBER_OF_DAY[selectedIndex];
        for (int i = 0; i < numberOfDay; i++) {
            cbDay.addItem(String.valueOf(i + 1));
        }
        cbDay.setSelectedItem(day);
        
        cbHour.removeAllItems();
        for (int i = 0; i < 24; i++) {
            
            cbHour.addItem(String.valueOf(i)+":00");
        } 
        cbHour.setSelectedIndex(Hour);
    }

    private void setToday() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        cbMonth.setSelectedIndex(month);
        cbDay.setSelectedIndex(day - 1);    }

}
