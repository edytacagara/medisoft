/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.ui.common.impl;

/**
 *
 * @author Mariusz Batyra
 */
public class Item<V> implements Comparable<Item> {

    private final V value;
    private final String description;

    public Item(V value, String description) {
        this.value = value;
        this.description = description;
    }

    public V getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Item item) {
        return getDescription().compareTo(item.getDescription());
    }

    @Override
    public boolean equals(Object object) {
        Item item = (Item) object;
        if (item != null) {
            return value.equals(item.getValue());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return description;
    }

}
