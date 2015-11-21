/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.domain.stock;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import pl.medisoft.domain.user.User;

/**
 *
 * @author Mariusz Batyra
 */
@Entity
@Table(name = "STOCK_INFO")
public class StockInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ITEM_ID")
    private Long itemId;
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @Column(name = "TOTAL_VALUE")
    private Long totalValue;
    @Column(name = "CURRENT_VALUE")
    private Long currentValue;
    @Column(name = "IN_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inDate;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User userId;

    public StockInfo() {
    }

    public StockInfo(Long itemId) {
        this.itemId = itemId;
    }

    public StockInfo(Long itemId, Long totalValue) {
        this.itemId = itemId;
        this.totalValue = totalValue;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Long totalValue) {
        this.totalValue = totalValue;
    }

    public Long getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Long currentValue) {
        this.currentValue = currentValue;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

}
