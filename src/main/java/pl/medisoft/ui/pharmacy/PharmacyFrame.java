/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.pharmacy;

import com.sun.net.httpserver.Headers;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;
import pl.medisoft.application.configuration.Configuration;
import pl.medisoft.application.configuration.ModuleEnum;
import pl.medisoft.application.message.Messages;
import pl.medisoft.domain.pharmacy.Calculation;
import pl.medisoft.domain.pharmacy.Medicament;
import pl.medisoft.infrastructure.pharmacy.medicament.MedicamentsDaoJpa;
import pl.medisoft.ui.common.BaseFrame;

/**
 *
 * @author Mariusz Batyra
 */
public class PharmacyFrame extends BaseFrame {

    private final Messages messages = Messages.getInstace();
    private final String MODULE_NAME = messages.get(ModuleEnum.PHARMACY.getMessageKey());
    private static final String[] HEADERS = {"lp", "name", "wskazanie","pakowanie","ilosc","cena"};
    private MedicamentsDaoJpa medJpa = new MedicamentsDaoJpa();
    private List<Medicament> listMed;
    private final JFrame parent;
    private List<Calculation> koszyk;
    public PharmacyFrame(final JFrame parent) {
        super(parent);
        this.parent = parent;
        setTitle(Configuration.TITLE + " " + Configuration.VERSION + " " + MODULE_NAME);
        tworzKoszyk();
        initComponents();
        customize();
        setResizable(false);
        
        
    }

    public void tworzKoszyk(){
        koszyk = new ArrayList<>();
    }
    
    @Override
    public void customize() {
        this.listMed = medJpa.findALL();
       
        jTable1.setModel(new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return listMed.size();
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
                        return listMed.get(rowIndex).getMedicamentName();
                    case 2:
                        return listMed.get(rowIndex).getDisease();
                    case 3:
                        return listMed.get(rowIndex).getMeasure();
                    case 4:
                        return listMed.get(rowIndex).getAmount();
                    case 5:
                        return listMed.get(rowIndex).getPrice();
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        addMedicamentButton = new javax.swing.JButton();
        updateStateButton = new javax.swing.JButton();
        findButton = new javax.swing.JButton();
        utylizujButton = new javax.swing.JButton();
        addZamienikButton = new javax.swing.JButton();
        findZamienikButton = new javax.swing.JButton();
        listUtylizujButton = new javax.swing.JButton();
        listaSprzedazyButton = new javax.swing.JButton();
        addToSaleButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jInternalFrame1.setVisible(true);

        addMedicamentButton.setText("Dodaj lek");
        addMedicamentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMedicamentButtonActionPerformed(evt);
            }
        });

        updateStateButton.setText("Aktualizuj");
        updateStateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStateButtonActionPerformed(evt);
            }
        });

        findButton.setText("Szukaj lek");
        findButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findButtonActionPerformed(evt);
            }
        });

        utylizujButton.setText("Utylizuj");
        utylizujButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utylizujButtonActionPerformed(evt);
            }
        });

        addZamienikButton.setText("Dodaj Zamienik");
        addZamienikButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addZamienikButtonActionPerformed(evt);
            }
        });

        findZamienikButton.setText("Znajdz Zamienik");
        findZamienikButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findZamienikButtonActionPerformed(evt);
            }
        });

        listUtylizujButton.setText("Lista Utylizacji");
        listUtylizujButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listUtylizujButtonActionPerformed(evt);
            }
        });

        listaSprzedazyButton.setText("Lista Sprzedazy");

        addToSaleButton.setText("Dodaj do koszyka");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(addMedicamentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateStateButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(findButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(utylizujButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addZamienikButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listUtylizujButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(findZamienikButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addToSaleButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listaSprzedazyButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(addMedicamentButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateStateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(findButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(utylizujButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addZamienikButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(findZamienikButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listUtylizujButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addToSaleButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listaSprzedazyButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Lp.", "Nazwa", "Wskazanie", "Pakowanie", "Ilość", "Cena"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addMedicamentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMedicamentButtonActionPerformed
        // TODO add your handling code here:
        AddMedicament add = new AddMedicament(this);
        add.pack();
        add.setVisible(true);
        
    }//GEN-LAST:event_addMedicamentButtonActionPerformed

    private void updateStateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStateButtonActionPerformed
        // TODO add your handling code here:
        UpdateState updateState = new UpdateState(this);
        updateState.pack();
        updateState.setVisible(true);
    }//GEN-LAST:event_updateStateButtonActionPerformed

    private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButtonActionPerformed
        // TODO add your handling code here:
        FindMedicament fm = new FindMedicament(this);
        fm.pack();
        fm.setVisible(true);
    }//GEN-LAST:event_findButtonActionPerformed

    private void utylizujButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utylizujButtonActionPerformed
        // TODO add your handling code here:
        AddReprocessing ar = new AddReprocessing(this);
        ar.pack();
        ar.setVisible(true);
    }//GEN-LAST:event_utylizujButtonActionPerformed

    private void addZamienikButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addZamienikButtonActionPerformed
        // TODO add your handling code here:
        AddEchange ae = new AddEchange(this);
        ae.pack();
        ae.setVisible(true);
    }//GEN-LAST:event_addZamienikButtonActionPerformed

    private void findZamienikButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findZamienikButtonActionPerformed
        // TODO add your handling code here:
        FindExchange fe = new FindExchange(this);
        fe.pack();
        fe.setVisible(true);
    }//GEN-LAST:event_findZamienikButtonActionPerformed

    private void listUtylizujButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listUtylizujButtonActionPerformed
        // TODO add your handling code here:
        FindReprocessing fr = new FindReprocessing(this);
        fr.pack();
        fr.setVisible(true);
        
    }//GEN-LAST:event_listUtylizujButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMedicamentButton;
    private javax.swing.JButton addToSaleButton;
    private javax.swing.JButton addZamienikButton;
    private javax.swing.JButton findButton;
    private javax.swing.JButton findZamienikButton;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton listUtylizujButton;
    private javax.swing.JButton listaSprzedazyButton;
    private javax.swing.JButton updateStateButton;
    private javax.swing.JButton utylizujButton;
    // End of variables declaration//GEN-END:variables
}
