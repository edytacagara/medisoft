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
public class UserDaoJpa extends BasicDaoJpa {

    private static final String FIND_BY_LOGIN = "select user from User user where user.login = :login";

    public User findByLogin(final String login) {
        return (User) getEntityManager().createQuery(FIND_BY_LOGIN)
                .setParameter("login", login).getSingleResult();
    }

}
