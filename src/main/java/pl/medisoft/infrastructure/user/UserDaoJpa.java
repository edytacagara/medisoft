/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.user;

import java.util.ArrayList;
import java.util.List;
import pl.medisoft.domain.user.User;
import pl.medisoft.infrastructure.BasicDaoJpa;

/**
 *
 * @author Mariusz Batyra
 */
public class UserDaoJpa extends BasicDaoJpa implements UserDao {

    private static final String FIND_ALL = "select u from User u";
    private static final String FIND_ALL_EMPLOYEES = "select distinct u from User u, UsersRoles r, EmploymentReq e where u.id = r.usersRolesPK.userId and r.usersRolesPK.roleId = e.roleId";
    private static final String FIND_BY_ID = "select user from User user where user.id = :id";
    private static final String FIND_BY_PESEL = "select user from User user where user.pesel = :pesel";
    private static final String FIND_BY_USERNAME_PASSHASH = "select user from User user "
            + " where user.username = :username "
            + " and user.passhash = :passhash ";

    @Override
    public User findById(Long id) {
        return (User) getEntityManager().createQuery(FIND_BY_ID).setParameter("id", id).getSingleResult();
    }

    @Override
    public User findByPesel(final String pesel) {
        return (User) getEntityManager().createQuery(FIND_BY_PESEL)
                .setParameter("pesel", pesel).getSingleResult();
    }

    @Override
    public User findByUsernameAndPasshas(String username, String passhash) {
        return (User) getEntityManager().createQuery(FIND_BY_USERNAME_PASSHASH)
                .setParameter("username", username)
                .setParameter("passhash", passhash).getSingleResult();
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList();
        users = this.getEntityManager().createQuery(UserDaoJpa.FIND_ALL).getResultList();
        return users;
    }

    public List<User> findAllEmployees() {
        List<User> users = new ArrayList();
        users = this.getEntityManager().createQuery(UserDaoJpa.FIND_ALL_EMPLOYEES).getResultList();
        return users;
    }
    
    public void addUser(User user){
        this.getEntityManager().getTransaction().begin();
        this.getEntityManager().persist(user);
        this.getEntityManager().getTransaction().commit();
    }
}
