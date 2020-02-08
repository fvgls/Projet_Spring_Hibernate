/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.ensg.Projet_Spring_Hibernate.controller;

import eu.ensg.Projet_Spring_Hibernate.model.*;
import java.util.ArrayList;
import java.util.List;
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
    @Autowired
    private ParticipantRepository participantRepository;
    
    
    /**
     * Post method to create a new event with params directly
     * @param intitule
     * @param theme
     * @param model
     * @return String event
     */
    @PostMapping(path="/create")
	public @ResponseBody String createNewEvent (@RequestParam String intitule, @RequestParam String theme, Model model) {
	
	    Event e = new Event();
	    e.setIntitule(intitule);
	    e.setTheme(theme);
	    eventRepository.save(e);
	    
	    model.addAttribute("event", e);
	
	    return "createEvents: " + e.toString();
	}
    
    /**
     * Post request to add new Event from form
     * @param model
     * @param newEvent
     * @return View /event/all
     */
    @PostMapping(path = "/addEvent")
    public String addNewEvent(Model model, @ModelAttribute("newEvent") Event newEvent) {

        if (newEvent.getIntitule() != null 
                && newEvent.getIntitule().length() > 0
                && newEvent.getTheme() != null 
                && newEvent.getTheme().length() > 0) {
            eventRepository.save(newEvent);

            model.addAttribute("event", newEvent);
            
            return "redirect:/event/all";
        }

        model.addAttribute("errorMessage", "Name and email are requested");
        
        return "addEvent";
    }
  
  
  /**
   * Get event information by id
   * @param num_event
   * @param model
   * @return View eventInfo
   */
  @GetMapping(path = "/{num_event}")
    public String getEventFromId(@PathVariable int num_event, Model model) {
        
        Optional<Event> ev = eventRepository.findById(num_event);
        
        if (ev.isPresent()) {
            model.addAttribute("event", ev.get());
            return "eventInfo";
        }
        model.addAttribute("errorMessage", "An error has occured, try again later");
        
        // Send to view
        return "eventsList";

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
     * Post request to add this participant to the event
     * @param newParticipant
     * @param model
     * @return 
     */
    @PostMapping("/addParticipant/{num_event}")
    public String addParticipantToEvent(@PathVariable int num_event, Model model, @ModelAttribute("newParticipant") Participant newParticipant) {
        
        Optional<Event> ev = eventRepository.findById(num_event);
        if (ev.isPresent()) {
            
            if (newParticipant.getName() != null 
                    && newParticipant.getName().length() > 0
                    && newParticipant.getEmail() != null 
                    && newParticipant.getEmail().length() > 0) {


                newParticipant.setEvent(ev.get());
                
                participantRepository.save(newParticipant);

                model.addAttribute("participant", newParticipant);

                return "redirect:/event/listParticipants/" + ev.get().getNum_event();
            }
            model.addAttribute("events", ev);
            model.addAttribute("errorMessage", "Intitule and them of events are requested");
        }
        
            model.addAttribute("errorMessage", "An error has occured, try again later");
        

        return "addParticipant";
    }
    
    
    /**
     * Get list of participants for the given event
     * @param num_event
     * @param model
     * @return View participantsList
     */
    @GetMapping("/listParticipants/{num_event}")
    public String listParticipant(@PathVariable int num_event, Model model) {
        Optional<Event> ev = eventRepository.findById(num_event);
        if (ev.isPresent()) {
            model.addAttribute("listParticipant", ev.get().getParticipants());
            model.addAttribute("event", ev.get());
        }
        
        return "participantsList";
    }
}
