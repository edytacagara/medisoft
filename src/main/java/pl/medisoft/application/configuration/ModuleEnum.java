/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.application.configuration;

import pl.medisoft.ui.admin.clinic.ClinicAdminFrame;
import pl.medisoft.ui.admin.system.SysAdminFrame;
import pl.medisoft.ui.admin.user.UserAdminFrame;
import pl.medisoft.ui.doctor.DoctorFrame;
import pl.medisoft.ui.patient.PatientFrame;
import pl.medisoft.ui.pharmacy.PharmacyFrame;

/**
 *
 * @author Mariusz Batyra
 */
public enum ModuleEnum {

    ADMIN_SYS("ADMIN_SYS", SysAdminFrame.class, "module.admin.sys"),
    ADMIN_USER("ADMIN_USER", UserAdminFrame.class, "module.admin.user"),
    ADMIN_CLINIC("ADMIN_CLINIC", ClinicAdminFrame.class, "module.admin.clinic"),
    DOCTOR("DOCTOR", DoctorFrame.class, "module.doctor"),
    PATIENT("PATIENT", PatientFrame.class, "module.patient"),
    PHARMACY("PHARMACY", PharmacyFrame.class, "module.pharmacy");

    private final String roleId;
    private final Class clazz;
    private final String messageKey;

    private ModuleEnum(final String roleId, final Class clazz, final String messageKey) {
        this.roleId = roleId;
        this.clazz = clazz;
        this.messageKey = messageKey;
    }

    public String getRoleId() {
        return roleId;
    }

    public Class getClazz() {
        return clazz;
    }
    
    public String getMessageKey() {
        return messageKey;
    }

    public static ModuleEnum fromRole(final String roleId) {
        for (final ModuleEnum i : ModuleEnum.values()) {
            if (i.getRoleId().equals(roleId)) {
                return i;
            }
        }
        return null;
    }

}
