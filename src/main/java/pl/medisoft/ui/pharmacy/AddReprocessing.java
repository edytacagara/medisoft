/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.pharmacy;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pl.medisoft.domain.pharmacy.Medicament;
import pl.medisoft.domain.pharmacy.Reprocessing;
import pl.medisoft.infrastructure.pharmacy.medicament.MedicamentsDaoJpa;
import pl.medisoft.infrastructure.pharmacy.reprocesing.ReprocesingDaoJpa;
import pl.medisoft.ui.common.BaseFrame;

/**
 *
 * @author Piotr
 */
public class AddReprocessing extends BaseFrame {
 
    private Medicament m;
    private Reprocessing r;
    private ReprocesingDaoJpa daoJpa = new ReprocesingDaoJpa();
    private List<Medicament> medicamentList;
    private MedicamentsDaoJpa medicamentJpa = new MedicamentsDaoJpa();
    private final JFrame parent;
    
    public AddReprocessing(final JFrame parent) {
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

        saveButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        medicamentComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        saveButton.setText("Dodaj");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Ilość:");

        jTextField1.setText("0");

        medicamentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicamentComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(saveButton)
                    .addComponent(medicamentComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(medicamentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(saveButton)
                .addGap(104, 104, 104))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void medicamentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicamentComboBoxActionPerformed
        // TODO add your handling code here:
        refreshData((Medicament)((JComboBox)evt.getSource()).getSelectedItem());
    }//GEN-LAST:event_medicamentComboBoxActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        r = new Reprocessing();
        r.setMedicament(m.getId());
        r.setAmount(Double.parseDouble(jTextField1.getText()));
        daoJpa.addReprocesing(r);
       JOptionPane.showMessageDialog(this,"Dodano");
    }//GEN-LAST:event_saveButtonActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<Medicament> medicamentComboBox;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void customize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void refreshData(Medicament medicament) {
        m = medicament;
        
    }
}
