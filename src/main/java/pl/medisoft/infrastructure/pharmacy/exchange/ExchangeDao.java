/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.pharmacy.exchange;

import java.util.List;
import pl.medisoft.domain.pharmacy.Exchange;

/**
 *
 * @author Piotr
 */
public interface ExchangeDao {
    
    void addExchange(Exchange exchange);
    List<Exchange> findAll(Long id);
    
    
}
