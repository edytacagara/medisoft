/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure;

import javax.persistence.EntityManager;

/**
 *
 * @author Mariusz Batyra
 */
public class BasicDaoJpa {

    public BasicDaoJpa() {

    }

    protected EntityManager getEntityManager() {
        return EntityManagerSingleton.getInstance();
    }

}
