/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.common;

import javax.swing.JFrame;

/**
 *
 * @author Mariusz Batyra
 */
public interface BaseFrame {
    
    JFrame getParent();
    void addWindowListener();

}
