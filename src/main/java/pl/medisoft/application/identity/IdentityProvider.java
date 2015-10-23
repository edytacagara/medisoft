/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.application.identity;

import java.util.logging.Level;
import java.util.logging.Logger;
import pl.medisoft.domain.identity.Identity;
import pl.medisoft.domain.user.User;
import pl.medisoft.infrastructure.user.UserDao;
import pl.medisoft.infrastructure.user.UserDaoJpa;

/**
 *
 * @author Mariusz Batyra
 */
public class IdentityProvider {

    private static final Logger LOG = Logger.getLogger(IdentityProvider.class.getName());

    private static Identity identity = null;
    private final UserDao userDao;

    public IdentityProvider() {
        userDao = new UserDaoJpa();
    }

    public boolean login(final String pesel, final String passhash) {
        try {
            final User user = userDao.findByPeselAndPasshas(pesel, passhash);
            if (user != null) {
                identity = new Identity(user.getPesel(), user.getName(), user.getSurname());
                return true;
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
        return false;
    }

    public boolean logout() {
        identity = null;
        return true;
    }

}
