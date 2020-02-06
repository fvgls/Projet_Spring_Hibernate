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
 *
 * @author formation
 */
@Controller // This means that this class is a Controller
@RequestMapping(path = "/event") // This means URL's start with /demo (after Application path)
public class EventController {

    @Autowired
    private EventRepository eventRepository;
    
    @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewEvent (@RequestParam String intitule
      , @RequestParam String theme, Model model) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    Event e = new Event();
    e.setIntitule(intitule);
    e.setTheme(theme);
    eventRepository.save(e);
    
    model.addAttribute("event", e);
    
    return "createEvent";
  }
  
  
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

    @GetMapping(path = "/all")
    public String getAllEvents(Model model) {
        
        model.addAttribute("listEvents", eventRepository.findAll());

        // Send to view
        return "eventsList";

    }
    
    
    @PostMapping("/addParticipant")
    public String addParticipantToEvent(@ModelAttribute("newParticipant") Participant newParticipant, Model model) {
        
        
        return "pouet";
    }
}
