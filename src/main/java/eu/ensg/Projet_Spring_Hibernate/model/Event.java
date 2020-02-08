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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author formation
 */
@Entity
@Table(name="event")
public class Event {
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="num_event")
    private int num_event;
    
    @Column(name="intitule", nullable=false)
    private String intitule;
    
    @Column(name="theme", nullable=false)
    private String theme;
    
    //@Column(name="starting_date", nullable=false)
    private LocalDate starting_date;
    
    //@Column(name="duration", nullable=false)
    private Date duration;
    
    //@Column(name="nb_part_max", nullable=false)
    private Integer nb_part_max;
    
    //@Column(name="description", nullable=false)
    private String description;
    
    //@Column(name="organisator", nullable=false)
    private String organisator;
    
    //@Column(name="event_type", nullable=false)
    private String event_type;
    
    @OneToMany(mappedBy="event")
    private List<Participant> participants = new ArrayList<>();

    
    
    public int getNum_event() {
        return num_event;
    }

    public String getIntitule() {
        return intitule;
    }

    public String getTheme() {
        return theme;
    }

    public LocalDate getStarting_date() {
        return starting_date;
    }

    public Date getDuration() {
        return duration;
    }

    public Integer getNb_part_max() {
        return nb_part_max;
    }

    public String getDescription() {
        return description;
    }

    public String getOrganisator() {
        return organisator;
    }

    public String getEvent_type() {
        return event_type;
    }

    public List<Participant> getParticipants() {
        return participants;
    }


    public void setNum_event(int num_event) {
        this.num_event = num_event;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setStarting_date(LocalDate starting_date) {
        this.starting_date = starting_date;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public void setNb_part_max(Integer nb_part_max) {
        this.nb_part_max = nb_part_max;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOrganisator(String organisator) {
        this.organisator = organisator;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }
    
    
    
    public String toString() {
        return "{id: " + this.getNum_event() + ", intitule: " + this.getIntitule() + ", theme: " + this.getTheme() +  "}";
    }
}
