/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Mariusz Batyra
 */
public class EntityManagerSingleton {

    private static final String MEDISOFT_PERSISTENCE_UNIT = "MediSoftPU";

    private static EntityManager entityManager = null;

    private EntityManagerSingleton() {

    }

    private static void initEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(MEDISOFT_PERSISTENCE_UNIT);
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static EntityManager getInstance() {
        if (entityManager == null) {
            initEntityManager();
        }
        return entityManager;
    }

}
