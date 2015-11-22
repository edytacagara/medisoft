/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.adminsys.model;

import pl.medisoft.domain.user.User;

/**
 *
 * @author Rafal
 */
public class UserModelConverter {

    public static String[] convertModelToRow(final User user) {
        String[] row = new String[UserTableModel.COLNUM];
        row[0] = user.getName() == null ? "" : user.getName();
        row[1] = user.getSurname() == null ? "" : user.getSurname();
        row[2] = user.getEmail() == null ? "" : user.getEmail();
        row[3] = user.getCountry() == null ? "" : user.getCountry();
        row[4] = user.getCity() == null ? "" : user.getCity();
        row[5] = user.getPostalCode() == null ? "" : user.getPostalCode();
        row[6] = user.getStreet() == null ? "" : user.getStreet();
        row[7] = user.getHouseNumber() == null ? "" : user.getHouseNumber();
        row[8] = user.getUsername() == null ? "" : user.getUsername();
        return row;
    }

}
