/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.pharmacy.reprocesing;

import java.util.ArrayList;
import java.util.List;
import pl.medisoft.domain.pharmacy.Medicament;
import pl.medisoft.domain.pharmacy.Reprocessing;
import pl.medisoft.infrastructure.BasicDaoJpa;

/**
 *
 * @author Piotr
 */
public class ReprocesingDaoJpa extends BasicDaoJpa implements ReprocesingDao{

    
    private static final String FIND_ALL = "select r from Reprocessing r";
    
    @Override
    public void addReprocesing(Reprocessing reprocesing) {
            getEntityManager().getTransaction().begin();            
            getEntityManager().persist(reprocesing);
            getEntityManager().getTransaction().commit();
    }

    @Override
    public List<Reprocessing> findAll() {
        List<Reprocessing> list = new ArrayList();
        list = this.getEntityManager().createQuery(FIND_ALL).getResultList();
        return list;
    }
    
}
