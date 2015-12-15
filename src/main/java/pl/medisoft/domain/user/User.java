/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.domain.user;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import pl.medisoft.domain.note.Note;
import pl.medisoft.domain.stock.StockInfo;

/**
 *
 * @author Mariusz Batyra
 */
@Entity
@Table(name = "USERS", catalog = "", schema = "MEDISOFT")
public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Long id;
    private String pesel;
    private String username;
    private String passhash;
    private String name;
    private String surname;
    private String email;
    private String country;
    private String city;
    private String postalCode;
    private String street;
    private String houseNumber;
    private List<RuleDef> userRules;
    private List<ParamDef> userParams;
    private List<RoleDef> userRoles;
    private UsersDetails usersDetails;
    private List<StockInfo> stockInfoList;
    private List<Note> notes;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String username, String passhash) {
        this.id = id;
        this.username = username;
        this.passhash = passhash;
    }

    @Id
    @TableGenerator(name="TABLE_GEN", table="SEQUENCE", pkColumnName="SEQ_NAME",
        valueColumnName="SEQ_COUNT", pkColumnValue="USERS_SEQ")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="TABLE_GEN")
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "PESEL")
    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    @Column(name = "PASSHASH")
    public String getPasshash() {
        return passhash;
    }

    public void setPasshash(String passhash) {
        this.passhash = passhash;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "SURNAME")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "COUNTRY")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "POSTAL_CODE")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Column(name = "STREET")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "HOUSE_NUMBER")
    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @ManyToMany
    @JoinTable(name = "USERS_RULES",
            joinColumns = {
                @JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {
                @JoinColumn(name = "RULE_ID", referencedColumnName = "ID")})
    public List<RuleDef> getUserRules() {
        return userRules;
    }

    public void setUserRules(List<RuleDef> userRules) {
        this.userRules = userRules;
    }

    @ManyToMany
    @JoinTable(name = "USERS_PARAMS",
            joinColumns = {
                @JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {
                @JoinColumn(name = "PARAM_ID", referencedColumnName = "ID")})
    public List<ParamDef> getUserParams() {
        return userParams;
    }

    public void setUserParams(List<ParamDef> userParams) {
        this.userParams = userParams;
    }

    @ManyToMany
    @JoinTable(name = "USERS_ROLES",
            joinColumns = {
                @JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {
                @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")})
    public List<RoleDef> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<RoleDef> userRoles) {
        this.userRoles = userRoles;
    }

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    public UsersDetails getUsersDetails() {
        return usersDetails;
    }

    public void setUsersDetails(UsersDetails usersDetails) {
        this.usersDetails = usersDetails;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    public List<StockInfo> getStockInfoList() {
        return stockInfoList;
    }

    public void setStockInfoList(List<StockInfo> stockInfoList) {
        this.stockInfoList = stockInfoList;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
    
    @Override
    public String toString() {
        return this.name + " " + this.surname;
    }

}
