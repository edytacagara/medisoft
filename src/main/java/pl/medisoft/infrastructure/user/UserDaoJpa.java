/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.user;

import pl.medisoft.domain.user.User;
import pl.medisoft.infrastructure.BasicDaoJpa;

/**
 *
 * @author Mariusz Batyra
 */
public class UserDaoJpa extends BasicDaoJpa implements UserDao {

    private static final String FIND_BY_PESEL = "select user from User user where user.pesel = :pesel";
    private static final String FIND_BY_PESEL_PASSHASH = "select user from User user "
                    + " where user.pesel = :pesel "
                    + " and user.passhash = :passhash ";
    
    @Override
    public User findByPesel(final String pesel) {
        return (User) getEntityManager().createQuery(FIND_BY_PESEL)
                .setParameter("pesel", pesel).getSingleResult();
    }

    @Override
    public User findByPeselAndPasshas(String pesel, String passhash) {
        return (User) getEntityManager().createQuery(FIND_BY_PESEL_PASSHASH)
                .setParameter("pesel", pesel)
                .setParameter("passhash", passhash).getSingleResult();
    }

}
