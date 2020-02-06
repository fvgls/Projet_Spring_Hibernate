/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.ensg.Projet_Spring_Hibernate.controller;

import eu.ensg.Projet_Spring_Hibernate.model.EventRepository;
import eu.ensg.Projet_Spring_Hibernate.model.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Controller for the main application
 * @author fvgls
 */
@Controller
@RequestMapping(path="/")
public class MainController {
    
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
    @GetMapping(path = "/addParticipant")
    public String addParticipantPage(Model model) {
        Participant newParticipant = new Participant();
        model.addAttribute("newParticipant", newParticipant);
        model.addAttribute("listEvents", eventRepository.findAll());
        
        // Send to view
        return "addParticipant";
    }
}
