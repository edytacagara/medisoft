/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.admin.clinic;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import pl.medisoft.domain.stock.StockInfo;
import pl.medisoft.domain.user.User;
import pl.medisoft.infrastructure.stock.StockDaoJpa;

/**
 *
 * @author Edyta Cagara
 */
public class StockTableModel extends AbstractTableModel{

    private StockDaoJpa stockDaoJpa;
    private List<StockInfo> stockInfos;
    
    public StockTableModel(){
        super();
        stockDaoJpa = new StockDaoJpa();
        stockInfos = stockDaoJpa.findAll();
    }
    
    @Override
    public int getRowCount() {
        return stockInfos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StockInfo stockInfo =  stockInfos.get(rowIndex);
        switch(columnIndex){
            case 0:
                return stockInfo.getItemId().toString();
            case 1:
                return stockInfo.getDescription();
            case 2:
                User user = stockInfo.getUserId();
                return user.toString();
            case 3:
                return stockInfo.getTotalValue().toString();
            case 4:
                return stockInfo.getCurrentValue().toString();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0:
                return "Numer";
            case 1:
                return "Opis";
            case 2:
                return "Id osoby";
            case 3:
                return "Wartosc";
            case 4:
                return "Wartosc po amortyzacji";
        }
        return null;
    }
}
