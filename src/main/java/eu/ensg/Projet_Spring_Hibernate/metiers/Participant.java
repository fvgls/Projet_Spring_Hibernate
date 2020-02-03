/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.ensg.Projet_Spring_Hibernate.metiers;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author formation
 */
@Entity
@Table(name = "participant")
public class Participant {
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="num_pers")
    private int num_pers;
    
    @Column(name="nom", nullable=false)
    private String nom;
    
    @Column(name="prenom", nullable=false)
    private String prenom;
    
    @Column(name="email", nullable=false)
    private String email;
    
    @Column(name="date_naiss", nullable=false)
    private LocalDate date_naiss;
    
    @Column(name="organisation", nullable=false)
    private String organisation;
    
    @Column(name="observations", nullable=false)
    private String observations;
    
    //@ManyToOne
    //private Evenement evenement;
    
    
    public Participant(){
        
    }
    
    public Participant(String nom, String prenom, String email, LocalDate date_naiss, String organisation, String observations
    ) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date_naiss = date_naiss;
        this.organisation = organisation;
        this.observations = observations;
    }
    
    public int getNum_pers() {
        return num_pers;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDate_naiss() {
        return date_naiss;
    }

    public String getOrganisation() {
        return organisation;
    }

    public String getObservations() {
        return observations;
    }

    public void setNum_pers(int num_pers) {
        this.num_pers = num_pers;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate_naiss(LocalDate date_naiss) {
        this.date_naiss = date_naiss;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
    
    public String toString() {
        return "{nom: " + this.getNom() + ", prenom: " + this.getPrenom() + ", email: " + this.getEmail() + "}";
    }
}

