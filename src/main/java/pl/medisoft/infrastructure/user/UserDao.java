/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.user;

import java.util.List;
import pl.medisoft.domain.user.User;

/**
 *
 * @author Mariusz Batyra
 */
public interface UserDao {
    
    User findById(final Long id);
    User findByPesel(final String pesel);
    User findByUsernameAndPasshas(final String username, final String passhash);
    List<User> findAll();
    
}
