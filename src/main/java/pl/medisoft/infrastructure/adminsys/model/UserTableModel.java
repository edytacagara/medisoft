/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.adminsys.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import pl.medisoft.application.message.Messages;
import pl.medisoft.domain.user.User;

/**
 *
 * @author Rafal
 */
public class UserTableModel extends AbstractTableModel {

    public final static int COLNUM = 9;

    private String[][] values = null;
    
    private String[] columns;

    private final List<User> usersList;

    private Messages messages;

    public UserTableModel(List<User> usersList) {
        this.usersList = usersList;
        this.messages = Messages.getInstace();
        this.initializeData();
        this.initializeColumns();
    }

    private void initializeData() {
        this.values = new String[this.usersList.size()][];
        int i = 0;
        for (User user : this.usersList) {
            this.values[i++] = UserModelConverter.convertModelToRow(user);
        }
    }

    private void initializeColumns() {
        this.columns = new String[]{"app.user.name","app.user.surname","app.user.email","app.user.country","app.user.city","app.user.postalCOde","app.user.street",
        "app.user.houseNumber","app.user.userName"};
        
    }

    @Override
    public String getColumnName(int column) {
        return this.messages.get(this.columns[column]);
    }

    @Override
    public int getRowCount() {
        return this.values.length;
    }

    @Override
    public int getColumnCount() {
        return UserTableModel.COLNUM;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.values[rowIndex][columnIndex];
    }
}
