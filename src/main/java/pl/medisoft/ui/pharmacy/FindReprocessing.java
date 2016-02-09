/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.pharmacy;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;
import pl.medisoft.application.message.Messages;
import pl.medisoft.domain.pharmacy.Medicament;
import pl.medisoft.domain.pharmacy.Reprocessing;
import pl.medisoft.infrastructure.pharmacy.medicament.MedicamentsDaoJpa;
import pl.medisoft.infrastructure.pharmacy.reprocesing.ReprocesingDaoJpa;
import pl.medisoft.ui.common.BaseFrame;

/**
 *
 * @author Piotr
 */
public class FindReprocessing extends BaseFrame {

    private final Messages messages = Messages.getInstace();
    private Reprocessing r;
    private ReprocesingDaoJpa daoJpa = new ReprocesingDaoJpa();
    private List<Reprocessing> reprocessingsList;
    private static final String[] HEADERS = {"lp", "nazwa","ilosc"};
    private MedicamentsDaoJpa medicamentJpa = new MedicamentsDaoJpa();
    private final JFrame parent;
   
    public FindReprocessing(final JFrame parent) {
        super(parent);
        this.parent = parent;
        initComponents();
        customize();
        
    }

   

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

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
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void customize() {
        reprocessingsList = daoJpa.findAll();
        
        jTable1.setModel(new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return reprocessingsList.size();
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
                        return medicamentJpa.findName(reprocessingsList.get(rowIndex).getMedicament());
                    case 2:
                        return reprocessingsList.get(rowIndex).getAmount();
                    
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
