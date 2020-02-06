/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.ensg.Projet_Spring_Hibernate.controller;

import eu.ensg.Projet_Spring_Hibernate.model.*;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller for class Event
 * @author fvgls
 */
@Controller
@RequestMapping(path = "/event")
public class EventController {
    
    @Autowired
    private EventRepository eventRepository;
    
    
    /**
     * Post method to create a new event with params directly
     * @param intitule
     * @param theme
     * @param model
     * @return View createEvent
     */
    @PostMapping(path="/add")
  public @ResponseBody String addNewEvent (@RequestParam String intitule, @RequestParam String theme, Model model) {

    Event e = new Event();
    e.setIntitule(intitule);
    e.setTheme(theme);
    eventRepository.save(e);
    
    model.addAttribute("event", e);
    
    return "createEvents: " + e.toString();
  }
  
  
  /**
   * Get event information by id
   * @param num_event
   * @param model
   * @return View addParticipantToEvent
   */
  @GetMapping(path = "/{num_event}")
    public String getEventFromId(@PathVariable int num_event, Model model) {
        
        Optional<Event> ev = eventRepository.findById(num_event);
        
        if (ev.isPresent()) {
            model.addAttribute("event", ev.get());
        }
        else {
            model.addAttribute("event", null);
        }
        
        // Send to view
        return "addParticipantToEvent";

    }

    
    /**
     * Get all events
     * @param model
     * @return View eventsList
     */
    @GetMapping(path = "/all")
    public String getAllEvents(Model model) {
        model.addAttribute("listEvents", eventRepository.findAll());

        // Send to view
        return "eventsList";
    }
    
    
    /**
     * 
     * @param newParticipant
     * @param model
     * @return 
     */
    @PostMapping("/addParticipant")
    public String addParticipantToEvent(@ModelAttribute("newParticipant") Participant newParticipant, Model model) {

        return "pouet";
    }
}
