/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.domain.note;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "NOTES")
public class Note implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String data;
    private Date issueDate;
    private User user;
    private Long deleted;
    private Date lastModify;

    public Note() {
    }

    public Note(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Lob
    @Column(name = "DATA")
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Column(name = "ISSUE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "DELETED")
    public Long getDeleted() {
        return deleted;
    }

    public void setDeleted(Long deleted) {
        this.deleted = deleted;
    }

    @Column(name = "LAST_MODIFY")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastModify() {
        return lastModify;
    }

    public void setLastModify(Date lastModify) {
        this.lastModify = lastModify;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Note)) {
            return false;
        }
        Note other = (Note) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
