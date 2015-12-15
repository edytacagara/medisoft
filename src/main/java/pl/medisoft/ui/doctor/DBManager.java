/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.doctor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pl.medisoft.infrastructure.BasicDaoJpa;
import pl.medisoft.infrastructure.EntityManagerSingleton;

/**
 *
 * @author michal.zahir
 */
public class DBManager extends BasicDaoJpa {

    EntityManagerFactory emf;
    EntityManager em;//  =  getEntityManager();// emf.createEntityManager();

    //EntityManagerSingleton entityManager ;
    Doctor c;

    //used for inserts
    public DBManager() {
        //  emf = Persistence.createEntityManagerFactory("MediSoftPU");
        // em  =  getEntityManager();// emf.createEntityManager();
        //  BasicDaoJpa B = new BasicDaoJpa();
        // em = EntityManagerSingleton.getInstance();
        emf = EntityManagerSingleton.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();
    }

    //used for update or delete
    public DBManager(Doctor c) {
        // emf = Persistence.createEntityManagerFactory("MediSoftPU");
        //  em =  getEntityManager(); //emf.createEntityManager();
        //           em = EntityManagerSingleton.getInstance();
        emf = EntityManagerSingleton.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();
        this.c = c;
    }

    //clean up all instances of this class
    public void close() {

        em.close();
        emf.close();
    }

    //insert this record
    public void insert(Doctor c) {
        em.getTransaction().begin();
        em.persist(c);

        em.getTransaction().commit();
    }

    //find a record by it's id
    public Doctor findById(int id) {
        Doctor c = em.find(Doctor.class, id);

        return c;
    }

    //delete this record
    public void delete(Doctor c) {
        em.getTransaction().begin();
        //this is a little weird as we have to find the object once again
        //before its deleted - required because the object has to be in
        //the same context - too complicated to explain fully here
        long x = c.getId();

        Doctor contact = findById((int) (x));
        em.remove(contact);
        em.getTransaction().commit();
    }

    //update this record
    public void update(Doctor c) {
        Doctor contacts = em.find(Doctor.class, c.getId());
        em.getTransaction().begin();
        contacts.setName(c.getName());
        contacts.setLastName(c.getLastName());
        contacts.setId(c.getId());
        contacts.setSpecialty(c.getSpecialty());
        contacts.setTitle(c.getTitle());
        contacts.setEmail(c.getEmail());
        contacts.setDateOfBirth(c.getDateOfBirth());
        contacts.setOfficeAddress(c.getOfficeAddress());
        contacts.setOfficePhone(c.getOfficePhone());
        contacts.setExperienceYears(c.getExperienceYears());
        contacts.setPhoneNumber(c.getPhoneNumber());

        em.getTransaction().commit();
    }
}
