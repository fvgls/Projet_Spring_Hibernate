/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.ensg.Projet_Spring_Hibernate.model;

import org.springframework.data.repository.CrudRepository;

/**
 * EventRepository for class Event
 * @author fvgls
 */
public interface EventRepository extends CrudRepository<Event, Integer> {
    
}
