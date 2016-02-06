/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.admin.clinic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pl.medisoft.domain.Patient.Visit;
import pl.medisoft.domain.user.User;
import pl.medisoft.infrastructure.visit.VisitDao;
import pl.medisoft.infrastructure.visit.VisitDaoJpa;

/**
 *
 * @author Edyta Cagara
 */
public class VisitTableModel extends AbstractTableModel{

    private final VisitDao visitDao;
    private List<Visit> visits;
    
    public VisitTableModel(){
        this.visitDao = new VisitDaoJpa();
        this.visits = new ArrayList<Visit>();
    }
    
    public void updateModel(User doctor, Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.visits = this.visitDao.findAllVisit(doctor.getId(),dateFormat.format(date));
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return this.visits.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Visit visit = this.visits.get(rowIndex);
        switch(columnIndex){
            case 0:
                return visit.getVisitDate().toString();
            case 1:
                return visit.getPatient().toString();
            case 2:
                return visit.getVisitType().getDescription();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "Data";
            case 1:
                return "Pacjent";
            case 2:
                return "Rodzaj wizyty";
        }
        return "";
    }
    
    
}
