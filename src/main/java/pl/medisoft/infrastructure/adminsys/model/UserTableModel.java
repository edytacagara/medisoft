/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.adminsys.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pl.medisoft.application.message.Messages;
import pl.medisoft.domain.user.User;
import pl.medisoft.infrastructure.user.UserDao;
import pl.medisoft.infrastructure.adminsys.model.modelinterface.UserSaveInterface;

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
    
    private List<Integer> changedIndex = new ArrayList<>();
    
    private UserDao userDao;
    
    private UserSaveInterface saveInterface;

    public UserTableModel(List<User> usersList,UserDao userDao,UserSaveInterface saveInterface) {
        this.saveInterface = saveInterface;
        this.usersList = usersList;
        this.userDao = userDao;
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

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(!this.values[rowIndex][columnIndex].equals(aValue.toString())) {
            this.values[rowIndex][columnIndex] = aValue.toString();
            this.changedIndex.add(rowIndex);
            this.saveInterface.buttonActrive();
        }

    }
    
    public void saveData(){
        for(int i : this.changedIndex){
            User user = this.usersList.get(i);
            user = UserModelConverter.converRowToUser(this.values[i], user);
            this.userDao.updateUser(user);
        }
        this.changedIndex.clear();
    }
    
    
    
    
    
}
