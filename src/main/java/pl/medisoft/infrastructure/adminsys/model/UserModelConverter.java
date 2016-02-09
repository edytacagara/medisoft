/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.adminsys.model;

import jdk.nashorn.internal.objects.NativeDate;
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
    
    public static User converRowToUser(final String[] row,User user){
        user.setName(row[0].equals("") ? null : row[0]);
        user.setSurname(row[1].equals("") ? null : row[1]);
        user.setEmail(row[2].equals("") ? null : row[2]);
        user.setCountry(row[3].equals("") ? null : row[3]);
        user.setCity(row[4].equals("") ? null : row[4]);
        user.setPostalCode(row[5].equals("") ? null : row[5]);
        user.setStreet(row[6].equals("") ? null : row[6]);
        user.setHouseNumber(row[7].equals("") ? null : row[7]);
        user.setUsername(row[8].equals("") ? null : row[8]);
        return user;
    }

}
