/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.stock;

import java.util.List;
import pl.medisoft.domain.stock.StockInfo;

/**
 *
 * @author Edyta Cagara
 */
public interface StockDao {
    List<StockInfo> findAll();
    void addStockInfo(StockInfo stockInfo);
    boolean updateStockInfo(StockInfo stockInfo);
}
