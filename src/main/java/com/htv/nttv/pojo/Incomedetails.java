/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "incomedetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incomedetails.findAll", query = "SELECT i FROM Incomedetails i"),
    @NamedQuery(name = "Incomedetails.findById", query = "SELECT i FROM Incomedetails i WHERE i.id = :id"),
    @NamedQuery(name = "Incomedetails.findByName", query = "SELECT i FROM Incomedetails i WHERE i.name = :name"),
    @NamedQuery(name = "Incomedetails.findByIncome", query = "SELECT i FROM Incomedetails i WHERE i.income = :income"),
    @NamedQuery(name = "Incomedetails.findByDescription", query = "SELECT i FROM Incomedetails i WHERE i.description = :description"),
    @NamedQuery(name = "Incomedetails.findByDate", query = "SELECT i FROM Incomedetails i WHERE i.date = :date")})
public class Incomedetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "income")
    private Long income;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public Incomedetails() {
        date = new Date();
    }

    public Incomedetails(Integer id) {
        this.id = id;
    }

    public Incomedetails(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIncome() {
        return income;
    }

    public void setIncome(Long income) {
        this.income = income;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incomedetails)) {
            return false;
        }
        Incomedetails other = (Incomedetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.htv.nttv.pojo.Incomedetails[ id=" + id + " ]";
    }
    
}
