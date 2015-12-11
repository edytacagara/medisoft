/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.admin.user;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import pl.medisoft.application.identity.IdentityProvider;
import pl.medisoft.application.message.Messages;
import pl.medisoft.application.user.note.NoteBean;
import pl.medisoft.domain.identity.Identity;
import pl.medisoft.domain.note.Note;
import pl.medisoft.ui.common.BaseFrame;

/**
 *
 * @author Mariusz Batyra
 */
public class NotesFrame extends BaseFrame {

    private static final String PREFIX = "app.notes.";
    private static final String[] HEADERS = {"lp", "name", "date"};
    private final Messages messages = Messages.getInstace();
    private final NoteBean noteBean = new NoteBean();
    private final List<Note> userNotes;
    private Identity identity = IdentityProvider.identity;
    private final JFrame parent;

    public NotesFrame(final JFrame parent) {
        super(parent);
        this.parent = parent;
        this.userNotes = noteBean.findUserNotes(identity.getId());
        initComponents();
        customize();
        initDatatable();
    }

    @Override
    public void customize() {
        this.addNoteButton.setText(messages.get("app.notes.add"));
        for (int i = 0; i < notesTable.getColumnCount(); i++) {
            final String msg = messages.get(PREFIX + HEADERS[i]);
            notesTable.getTableHeader().getColumnModel().getColumn(i).setHeaderValue(msg);
        }
        ((BaseFrame) parent).customize();
    }

    private void initDatatable() {
        if (userNotes == null) {
            return;
        }
        notesTable.setModel(new AbstractTableModel() {

            @Override
            public int getRowCount() {
                return userNotes.size();
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
                        return userNotes.get(rowIndex).getName();
                    case 2:
                        return userNotes.get(rowIndex).getIssueDate();
                    default:
                        throw new UnsupportedOperationException("Column index: " + columnIndex);
                }
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addNoteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        notesTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        addNoteButton.setText("Dodaj notatkę");
        addNoteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNoteButtonActionPerformed(evt);
            }
        });

        notesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nazwa", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        notesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                notesTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(notesTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addNoteButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addNoteButton)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addNoteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNoteButtonActionPerformed
        NoteEditorFrame frame = new NoteEditorFrame(new Note());
        frame.setVisible(true);
    }//GEN-LAST:event_addNoteButtonActionPerformed

    private void notesTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notesTableMousePressed
        JTable table = (JTable) evt.getSource();
        Point p = evt.getPoint();
        int row = table.rowAtPoint(p);
        if (evt.getClickCount() == 2) {
            Note note = userNotes.get(row);
            NoteEditorFrame frame = new NoteEditorFrame(note);
            frame.setVisible(true);
        }
    }//GEN-LAST:event_notesTableMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNoteButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable notesTable;
    // End of variables declaration//GEN-END:variables
}
