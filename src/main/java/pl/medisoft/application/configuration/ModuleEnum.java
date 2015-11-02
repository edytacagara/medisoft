/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.application.configuration;

/**
 *
 * @author Mariusz Batyra
 */
public enum ModuleEnum {
    
    ADMIN_SYS("module.admin.sys"),
    ADMIN_USER("module.admin.user"),
    ADMIN_CLINIC("module.admin.clinic"),
    DOCTOR("module.doctor"),
    PATIENT("module.patient"),
    PHARMACY("module.pharmacy");
    
    private final String messageKey;
    
    private ModuleEnum(final String messageKey) {
        this.messageKey = messageKey;
    }

    public String getMessageKey() {
        return messageKey;
    }
    
}
