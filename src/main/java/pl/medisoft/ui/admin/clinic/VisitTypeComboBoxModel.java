/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.admin.clinic;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import pl.medisoft.domain.Patient.VisitType;
import pl.medisoft.infrastructure.visit.VisitDao;
import pl.medisoft.infrastructure.visit.VisitDaoJpa;

/**
 *
 * @author Edyta Cagara
 */
public class VisitTypeComboBoxModel extends DefaultComboBoxModel<VisitType>{
    
    private final VisitDao visitDao;
    private List<VisitType> visitTypes;
    
    public VisitTypeComboBoxModel(){
        super();
        this.visitDao = new VisitDaoJpa();
        this.visitTypes = visitDao.findAllVisitType();
    }
    
    @Override
    public int getSize(){
        return visitTypes.size();
    }
    
    @Override
    public VisitType getElementAt(int index){
        return this.visitTypes.get(index);
    }
}
