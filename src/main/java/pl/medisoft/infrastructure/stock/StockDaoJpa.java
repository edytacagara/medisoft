/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.stock;

import java.util.ArrayList;
import java.util.List;
import pl.medisoft.domain.stock.StockInfo;
import pl.medisoft.infrastructure.BasicDaoJpa;

/**
 *
 * @author Edyta Cagara
 */
public class StockDaoJpa extends BasicDaoJpa implements StockDao{

    private static final String FIND_ALL = "select s from StockInfo s";
    
    @Override
    public List<StockInfo> findAll() {
        List<StockInfo> stockInfos = new ArrayList();
        stockInfos = this.getEntityManager().createQuery(StockDaoJpa.FIND_ALL).getResultList();
        return stockInfos;
    }

    @Override
    public void addStockInfo(StockInfo stockInfo) {
        this.getEntityManager().getTransaction().begin();
        this.getEntityManager().persist(stockInfo);
        this.getEntityManager().getTransaction().commit();
    }

    @Override
    public boolean updateStockInfo(StockInfo stockInfo) {
        try {
            this.getEntityManager().getTransaction().begin();
            this.getEntityManager().merge(stockInfo);
            this.getEntityManager().getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
            return false;
        }
    }
    
}
