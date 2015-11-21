/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.user.param;

import pl.medisoft.infrastructure.BasicDaoJpa;

public class UserParamDaoJpa extends BasicDaoJpa implements UserParamDao {

    private static final String FIND_USER_PARAM = "select param.param_value from users_params param "
            + " where param.user_id = :userId "
            + " and param.param_id = :paramId";

    private static final String UPDATE_USER_PARAM = "update users_params "
            + " set param_value = :paramValue "
            + " where user_id = :userId "
            + " and param_id = :paramId";

    private static final String INSERT_USER_PARAM = "insert into users_params "
            + " values(:userId, :paramId, :paramValue)";

    @Override
    public String findByUserAndParam(Long userId, String paramId) {
        return (String) getEntityManager().createNativeQuery(FIND_USER_PARAM)
                .setParameter("userId", userId)
                .setParameter("paramId", paramId).getSingleResult();
    }

    @Override
    public int updateUserParam(Long userId, String paramId, String paramValue) {
        getEntityManager().getTransaction().begin();
        int result = getEntityManager().createNativeQuery(UPDATE_USER_PARAM)
                .setParameter("userId", userId)
                .setParameter("paramId", paramId)
                .setParameter("paramValue", paramValue).executeUpdate();
        if (result == 0) {
            getEntityManager().getTransaction().rollback();
        } else {
            getEntityManager().getTransaction().commit();
        }
        return result;
    }

    @Override
    public int insertUserParam(Long userId, String paramId, String paramValue) {
        getEntityManager().getTransaction().begin();
        int result = getEntityManager().createNativeQuery(INSERT_USER_PARAM)
                .setParameter("userId", userId)
                .setParameter("paramId", paramId)
                .setParameter("paramValue", paramValue).executeUpdate();
        if (result == 0) {
            getEntityManager().getTransaction().rollback();
        } else {
            getEntityManager().getTransaction().commit();
        }
        return result;
    }

}
