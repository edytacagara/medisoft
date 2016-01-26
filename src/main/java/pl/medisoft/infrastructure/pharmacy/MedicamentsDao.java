/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.pharmacy;

import java.util.List;
import pl.medisoft.domain.pharmacy.Medicament;

/**
 *
 * @author Piotr
 */
public interface MedicamentsDao {
    void addMedicament(Medicament medicament);
    List<Medicament> findALL();
    void updateMedicament();
    
}
