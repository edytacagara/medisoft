/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.pharmacy.medicament;

import java.util.ArrayList;
import java.util.List;
import pl.medisoft.domain.pharmacy.Medicament;
import pl.medisoft.domain.user.User;
import pl.medisoft.infrastructure.BasicDaoJpa;


/**
 *
 * @author Piotr
 */
public class MedicamentsDaoJpa extends BasicDaoJpa implements MedicamentsDao{

    private static final String FIND_ALL = "select m from Medicament m";
    private static final String FIND_BY_NAME = "select m from Medicament m where m.medicamentName = :name";
    
    
    @Override
    public void addMedicament(Medicament medicament) {
     
            getEntityManager().getTransaction().begin();            
            getEntityManager().persist(medicament);
            getEntityManager().getTransaction().commit();
        
        
    }

    @Override
    public List<Medicament> findALL() {
        List<Medicament> list = new ArrayList();
        list = this.getEntityManager().createQuery(FIND_ALL).getResultList();
        return list;
    }

    @Override
    public void updateMedicament() {
        
    }

    @Override
    public Medicament findByName(String name) 
    {   
        return (Medicament) getEntityManager().createQuery(FIND_BY_NAME).setParameter("name", name).getSingleResult();
    }
    
}
