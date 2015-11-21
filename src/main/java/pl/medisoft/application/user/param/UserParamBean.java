/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.application.user.param;

import pl.medisoft.application.message.LanguageEnum;
import pl.medisoft.infrastructure.user.param.UserParamDao;
import pl.medisoft.infrastructure.user.param.UserParamDaoJpa;

/**
 *
 * @author Mariusz Batyra
 */
public class UserParamBean {
    
    private final UserParamDao userParamDao = new UserParamDaoJpa();
    
    public UserParamBean() {
        
    }
    
    public LanguageEnum getUserLanguage(final Long userId) {
        try {
            String param = userParamDao.findByUserAndParam(userId, "LANG");
            if(param != null && !param.isEmpty()) {
                return LanguageEnum.fromValue(param);
            }
        } catch(Exception e) {
            
        }
        return null;
    }
    
}
