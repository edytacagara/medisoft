/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.application.identity;

import pl.medisoft.domain.identity.Identity;

/**
 *
 * @author Mariusz Batyra
 */
public class IdentityProvider {

    private static Identity identity = null;

    public IdentityProvider() {

    }

    // TODO logowanie usera
    public boolean login(final String username, final String passhash) {
        identity = new Identity();
        return true;
    }

    // TODO wylogowanie usera
    public boolean logout() {
        identity = null;
        return true;
    }

}
