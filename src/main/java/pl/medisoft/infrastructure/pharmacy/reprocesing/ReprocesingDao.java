/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.pharmacy.reprocesing;

import java.util.List;
import pl.medisoft.domain.pharmacy.Reprocessing;

/**
 *
 * @author Piotr
 */
public interface ReprocesingDao {
    
    void addReprocesing(Reprocessing reprocesing);
    List<Reprocessing> findAll();
}
