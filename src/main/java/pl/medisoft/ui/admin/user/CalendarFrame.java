/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.admin.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;
import pl.medisoft.application.configuration.Configuration;
import pl.medisoft.application.configuration.ModuleEnum;
import pl.medisoft.application.message.Messages;
import pl.medisoft.application.user.calendar.CalendarBean;
import pl.medisoft.domain.Patient.Visit;
import pl.medisoft.ui.common.BaseFrame;

/**
 *
 * @author Mariusz Batyra
 */
public class CalendarFrame extends BaseFrame {

    private static final String MONTH_MSG_PREFIX = "app.calendar.month";
    private static final int[] NUMBER_OF_DAY = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String PREFIX = "app.calendar.";
    private static final String[] HEADERS = {"lp", "doctorName", "patientName", "visitDate", "visitType"};
    private final Messages messages = Messages.getInstace();
    private final String MODULE_NAME = messages.get(ModuleEnum.ADMIN_USER.getMessageKey());
    private final JFrame parent;
    private final CalendarBean calendarBean = new CalendarBean();

    public CalendarFrame(final JFrame parent) {
        super(parent);
        this.parent = parent;
        setTitle(Configuration.TITLE + " " + Configuration.VERSION + " " + MODULE_NAME);
        initComponents();
        customize();
        setResizable(false);
        monthComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initDayCombo();
            }
        });
        initTable(new ArrayList<>());
    }

    private void initMonthCombo() {
        monthComboBox.removeAllItems();
        for (int i = 0; i < 12; i++) {
            String monthNameKey = MONTH_MSG_PREFIX + String.valueOf(i + 1);
            monthComboBox.addItem(messages.get(monthNameKey));
        }
        initDayCombo();
    }

    private void initDayCombo() {
        dayComboBox.removeAllItems();
        int selectedIndex = monthComboBox.getSelectedIndex();
        int numberOfDay = NUMBER_OF_DAY[selectedIndex];
        for (int i = 0; i < numberOfDay; i++) {
            dayComboBox.addItem(String.valueOf(i + 1));
        }
    }

    private void initTable(final List<Visit> list) {
        calendarTable.setModel(new AbstractTableModel() {

            @Override
            public int getRowCount() {
                return list.size();
            }

            @Override
            public int getColumnCount() {
                return 5;
            }

            @Override
            public String getValueAt(int rowIndex, int columnIndex) {
                Visit v = list.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return String.valueOf(rowIndex + 1);
                    case 1:
                        return v.getDoctor().getName() + " " + v.getDoctor().getSurname();
                    case 2:
                        return v.getPatient().getName() + " " + v.getPatient().getSurname();
                    case 3:
                        return v.getVisitDate().toString();
                    case 4:
                        return v.getVisitType().getDescription();
                    default:
                        return "error";
                }
            }
            
            @Override
            public String getColumnName(int columnIndex) {
                return messages.get(PREFIX + HEADERS[columnIndex]);
            }
        });
    }

    @Override
    public void customize() {
        initMonthCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        monthComboBox = new javax.swing.JComboBox();
        dayComboBox = new javax.swing.JComboBox();
        showButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        calendarTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        dayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        showButton.setText("Pokaż");
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        calendarTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(calendarTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(showButton)
                        .addGap(0, 81, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        int day = dayComboBox.getSelectedIndex() + 1;
        int month = monthComboBox.getSelectedIndex() + 1;
        String dayStr = String.valueOf(day);
        String monthStr = String.valueOf(month);
        if (day < 10) {
            dayStr = String.valueOf(0) + dayStr;
        }
        if (month < 10) {
            monthStr = String.valueOf(0) + monthStr;
        }
        String selectedDate = "2016-" + monthStr + "-" + dayStr;
        List<Visit> allVisit = calendarBean.findAllVisit(selectedDate);
        initTable(allVisit);
    }//GEN-LAST:event_showButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable calendarTable;
    private javax.swing.JComboBox dayComboBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox monthComboBox;
    private javax.swing.JButton showButton;
    // End of variables declaration//GEN-END:variables
}
