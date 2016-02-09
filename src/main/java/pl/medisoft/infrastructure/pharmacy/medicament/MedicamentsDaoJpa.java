/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.pharmacy.medicament;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import pl.medisoft.domain.pharmacy.Medicament;
import pl.medisoft.domain.user.User;
import pl.medisoft.infrastructure.BasicDaoJpa;


/**
 *
 * @author Piotr
 */
public class MedicamentsDaoJpa extends BasicDaoJpa implements MedicamentsDao{

    private static final String FIND_ALL = "select m from Medicament m";
    private static final String FIND_BY_NAME = "select m from Medicament m where lower(m.medicamentName) = :name";
    private static final String FIND_NAME = "select m.medicamentName from Medicament m where m.id = :id";
    private static final String FIND_BY_NAME_LAST = "select m from Medicament m where (m.medicamentName) = :name";
    
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
    public boolean updateMedicament(Medicament m) {
        try {
            this.getEntityManager().getTransaction().begin();
            this.getEntityManager().merge(m);
            this.getEntityManager().getTransaction().commit();
        return true;
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();           
            return false;
        }
    }

    @Override
    public String findName(Long id) 
    {   
        return (String) getEntityManager().createQuery(FIND_NAME).setParameter("id", id).getSingleResult();
    }

    @Override
    public Medicament findByName(String name) {
      try{
           return (Medicament) getEntityManager().createQuery(FIND_BY_NAME).setParameter("name", name).getSingleResult();
      }catch (Exception e) {
            e.printStackTrace();
            return null;
      }
      
    }

    @Override
    public Medicament findByNameLast(String name) {
        try{
           return (Medicament) getEntityManager().createQuery(FIND_BY_NAME_LAST).setParameter("name", name).getSingleResult();
      }catch (Exception e) {
            e.printStackTrace();
            return null;
      }
      
    }
    
}
