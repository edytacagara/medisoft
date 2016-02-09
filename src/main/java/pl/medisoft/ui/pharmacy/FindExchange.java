/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.pharmacy;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;
import pl.medisoft.application.message.Messages;
import pl.medisoft.domain.pharmacy.Exchange;
import pl.medisoft.domain.pharmacy.Medicament;
import pl.medisoft.infrastructure.pharmacy.exchange.ExchangeDaoJpa;
import pl.medisoft.infrastructure.pharmacy.medicament.MedicamentsDaoJpa;
import pl.medisoft.ui.common.BaseFrame;

/**
 *
 * @author Piotr
 */
public class FindExchange extends BaseFrame {

    private final Messages messages = Messages.getInstace();
    private Exchange e;
    private Medicament m;
    private List<Medicament> medicamentList;
    private List<Exchange> exchangesList;
    private MedicamentsDaoJpa medicamentJpa = new MedicamentsDaoJpa();
    private ExchangeDaoJpa exchangeDaoJpa = new ExchangeDaoJpa();
    private final JFrame parent;
    private static final String[] HEADERS = {"lp", "nazwa zamienika"};
    
    public FindExchange(final JFrame parent) {
        super(parent);
        this.parent = parent;
        initComponents();
        medicamentList = medicamentJpa.findALL();
        this.addToCOmbo(this.medicamentComboBox, medicamentList);
    }

    private void addToCOmbo(JComboBox<Medicament> comboBox, List<Medicament> data){
        for(Medicament i : data){
            comboBox.addItem(i);
        }
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        medicamentComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        medicamentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicamentComboBoxActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(medicamentComboBox, 0, 135, Short.MAX_VALUE)
                .addGap(243, 243, 243))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(medicamentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void medicamentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicamentComboBoxActionPerformed
        // TODO add your handling code here:
        refreshData((Medicament)((JComboBox)evt.getSource()).getSelectedItem());
    }//GEN-LAST:event_medicamentComboBoxActionPerformed

   
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<Medicament> medicamentComboBox;
    // End of variables declaration//GEN-END:variables

    private void refreshData(Medicament medicament) {
        m = medicament;
        customize();
    }

    @Override
    public void customize() {
       exchangesList = exchangeDaoJpa.findAll(m.getId());
       jTable1.setModel(new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return exchangesList.size();
            }

            @Override
            public int getColumnCount() {
                return HEADERS.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return rowIndex + 1;
                    case 1:
                        return exchangesList.get(rowIndex).getExchangeName();
                    
                    default:
                        throw new UnsupportedOperationException("Column index: " + columnIndex);
                }
            }
            
            @Override
            public String getColumnName(int columnIndex) {
                return messages.get(HEADERS[columnIndex]);
            }
        });
    }
}
