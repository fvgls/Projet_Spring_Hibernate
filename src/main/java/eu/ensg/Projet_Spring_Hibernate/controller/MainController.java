/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.ensg.Projet_Spring_Hibernate.controller;

import eu.ensg.Projet_Spring_Hibernate.model.Event;
import eu.ensg.Projet_Spring_Hibernate.model.EventRepository;
import eu.ensg.Projet_Spring_Hibernate.model.Participant;
import eu.ensg.Projet_Spring_Hibernate.model.ParticipantRepository;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Controller for the main application
 * @author fvgls
 */
@Controller
@RequestMapping(path="/")
public class MainController {
    
	@Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private EventRepository eventRepository;
    
    /**
     * Go to the index page
     * @param model
     * @return View index
     */
    @GetMapping(path = "/index")
    public String index(Model model) {
        // Send to view
        return "index";
    }
    
    /**
     * Go to the addParticipant form
     * @param model
     * @return View addParticipant
     */
    @GetMapping(path = "/addParticipant/{num_event}")
    public String addParticipantPage(@PathVariable int num_event, Model model) {
        Participant newParticipant = new Participant();
        model.addAttribute("newParticipant", newParticipant);
      
        
        Optional<Event> ev = eventRepository.findById(num_event);
        if (ev.isPresent()) {
            model.addAttribute("event", ev.get());
        }
        
        // Send to view
        return "addParticipant";
    }
    
    /**
     * go to the modifyParticipant form
     * @param num_pers
     * @param model
     * @return View modifyParticipant, if error participantInfo
     */
    @GetMapping(path = "/modifyParticipant/{num_pers}")
    public String modifyParticipantPage(@PathVariable int num_pers, Model model) {
    	
        Optional<Participant> participant = participantRepository.findById(num_pers);
      
        
        if (participant.isPresent()) {
            model.addAttribute("participant", participant.get());
            // Send to view
            return "modifyParticipant";
        }
        
        model.addAttribute("errorMessage", "An error has occured, try again later");
        
        // Send to view
        return "participantInfo";
    }
    
    
    /**
     * Go to the addEvent form
     * @param model
     * @return View addEvent
     */
    @GetMapping(path = "/addEvent")
    public String addEventPage(Model model) {
        Event newEvent = new Event();
        model.addAttribute("newEvent", newEvent);
        
        // Send to view
        return "addEvent";
    }
    
    
    /**
     * Go to the modifyEvent Page
     * @param num_pers
     * @param model
     * @return View modifyEvent, if error eventInfo
     */
    @GetMapping(path = "/modifyEvent/{num_even}")
    public String modifyEventPage(@PathVariable int num_even, Model model) {
    	
        Optional<Event> event = eventRepository.findById(num_even);
      
        
        if (event.isPresent()) {
            model.addAttribute("event", event.get());
            // Send to view
            return "modifyEvent";
        }
        
        model.addAttribute("errorMessage", "An error has occured, try again later");
        
        // Send to view
        return "eventInfo";
    }
}
