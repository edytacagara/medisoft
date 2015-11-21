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
    
    @Override
    public String findByUserAndParam(Long userId, String paramId) {
        return (String) getEntityManager().createNativeQuery(FIND_USER_PARAM)
                .setParameter("userId", userId)
                .setParameter("paramId", paramId).getSingleResult();
    }
    
}
