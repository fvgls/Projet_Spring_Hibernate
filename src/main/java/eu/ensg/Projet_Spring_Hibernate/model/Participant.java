/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.ensg.Projet_Spring_Hibernate.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Class Participant
 * Hibernate management
 * @author fvgls
 */
@Entity
@Table(name = "participant")
public class Participant {
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="num_pers")
    private int num_pers;
    
    @Column(name="name", nullable=false)
    private String name;
    
    @Column(name="firstname")
    private String firstname;
    
    @Column(name="email", nullable=false)
    private String email;
    
    @Column(name="birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth_date;
    
    @Column(name="organisation")
    private String organisation;
    
    @Column(name="observations")
    private String observations;
    
    @ManyToOne
    private Event event;
    
    
    /* Constructors */
    public Participant(){
        
    }
    
    public Participant(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    
    /* Getters & Setters */
    public int getNum_pers() {
        return num_pers;
    }

    public String getName() {
        return name;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public String getOrganisation() {
        return organisation;
    }

    public String getObservations() {
        return observations;
    }

    public Event getEvent() {
        return event;
    }
    

    public void setNum_pers(int num_pers) {
        this.num_pers = num_pers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
    
    
    /* Other functions */

    public String toString() {
        return "{name: " + this.getName() + ", firstname: " + this.getFirstname() + ", email: " + this.getEmail() + "}";
    }
}

