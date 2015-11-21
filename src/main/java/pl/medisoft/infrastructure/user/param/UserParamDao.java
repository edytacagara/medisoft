/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.user.param;

/**
 *
 * @author Mariusz Batyra
 */
public interface UserParamDao {
    
    String findByUserAndParam(final Long userId, final String paramId);
    
    int updateUserParam(final Long userId, final String paramId, final String paramValue);
    
    int insertUserParam(final Long userId, final String paramId, final String paramValue);
    
}
