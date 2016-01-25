/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.doctor;

/**
 *
 * @author michal.zahir
 */
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pl.medisoft.infrastructure.BasicDaoJpa;
import pl.medisoft.infrastructure.EntityManagerSingleton;
import pl.medisoft.domain.Patient.Prescription;

/**
 *
 * @author michal.zahir
 */
public class PrescriptionDBManager extends BasicDaoJpa {

    EntityManagerFactory emf;
    EntityManager em;//  =  getEntityManager();// emf.createEntityManager();

    //EntityManagerSingleton entityManager ;
    Prescription c;

    //used for inserts
    public PrescriptionDBManager() {
        //  emf = Persistence.createEntityManagerFactory("MediSoftPU");
        // em  =  getEntityManager();// emf.createEntityManager();
        //  BasicDaoJpa B = new BasicDaoJpa();
        // em = EntityManagerSingleton.getInstance();
        emf = EntityManagerSingleton.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();
    }

    //used for update or delete
    public PrescriptionDBManager(Prescription c) {
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
    public void insert(Prescription c) {
        em.getTransaction().begin();
        em.persist(c);

        em.getTransaction().commit();
    }

    //find a record by it's id
    public Prescription findById(BigDecimal id) {
        Prescription c = em.find(Prescription.class, id);

        return c;
    }

    public void delete(Prescription c) {
        em.getTransaction().begin();
        //this is a little weird as we have to find the object once again
        //before its deleted - required because the object has to be in
        //the same context - too complicated to explain fully here
        BigDecimal x = c.getId();

        Prescription contact = findById(x);
        em.remove(contact);
        em.getTransaction().commit();
    }

    //update this record
    public void update(Prescription c) {
        Prescription contacts = em.find(Prescription.class, c.getId());
        em.getTransaction().begin();
        contacts.setPatientName(c.getPatientName());

        contacts.setDescription(c.getDescription());

        contacts.setQuantityValue(c.getQuantityValue());
        contacts.setDateOfIssue(c.getDateOfIssue());
        contacts.setValidDate(c.getValidDate());
        contacts.setDoctorId(c.getDoctorId());

        em.getTransaction().commit();
    }

}
