/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.pharmacy.exchange;

import java.util.ArrayList;
import java.util.List;
import pl.medisoft.domain.pharmacy.Exchange;
import pl.medisoft.domain.pharmacy.Medicament;
import pl.medisoft.infrastructure.BasicDaoJpa;

/**
 *
 * @author Piotr
 */
public class ExchangeDaoJpa extends BasicDaoJpa implements ExchangeDao {

    private static final String FIND_ALL = "select e from Exchange e where e.medicament = :id";
    
    @Override
    public void addExchange(Exchange exchange) {
          getEntityManager().getTransaction().begin();            
            getEntityManager().persist(exchange);
            getEntityManager().getTransaction().commit();
    }

    @Override
    public List<Exchange> findAll(Long id) {
        List<Exchange> list = new ArrayList();
        list = this.getEntityManager().createQuery(FIND_ALL).setParameter("id", id).getResultList();
        return list;
    }
    
}
