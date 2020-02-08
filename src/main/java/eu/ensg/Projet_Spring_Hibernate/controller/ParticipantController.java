/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.ensg.Projet_Spring_Hibernate.controller;

import eu.ensg.Projet_Spring_Hibernate.model.*;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Controller for class Participant
 * @author fvgls
 */
@Controller 
@RequestMapping(path = "/participant")
public class ParticipantController {

    @Autowired
    private ParticipantRepository participantRepository;

    
    /**
     * Post request for creating new Participant with params directly
     * @param name
     * @param email
     * @param model
     * @return String participant
     */
    @PostMapping(path = "/create")
    public @ResponseBody
    String createNewParticipant(@RequestParam String name, @RequestParam String email, Model model) {

        Participant p = new Participant();
        p.setName(name);
        p.setEmail(email);
        participantRepository.save(p);

        model.addAttribute("participant", p);

        return "createParticipants: " + p.toString();
    }
    
    
    
    /**
     * Post request to add new Participant from form
     * @param model
     * @param newParticipant
     * @return View /participant/list
     */
    @PostMapping(path = "/addParticipant")
    public
    String addNewParticipant(Model model, @ModelAttribute("newParticipant") Participant newParticipant) {

        if (newParticipant.getName() != null 
                && newParticipant.getName().length() > 0
                && newParticipant.getEmail() != null 
                && newParticipant.getEmail().length() > 0) {
            participantRepository.save(newParticipant);

            model.addAttribute("participant", newParticipant);
            
            return "redirect:/participant/all";
        }

        model.addAttribute("errorMessage", "Name and email are requested");
        
        return "addParticipant";
    }
    
    
    
    /**
     * Get participant information by id
     * @param num_participant
     * @param model
     * @return View participantInfo
     */
    @GetMapping(path = "/{num_participant}")
    public String getParticipantFromId(@PathVariable int num_participant, Model model) {
        
        Optional<Participant> p = participantRepository.findById(num_participant);
        
        if (p.isPresent()) {
            model.addAttribute("participant", p.get());
            return "participantInfo";
        }
        model.addAttribute("errorMessage", "An error has occured, try again later");
        
        // Send to view
        return "participantsList";

    }

    
    /**
     * Get request to get all Participant
     * @param model
     * @return View participantList
     */
    @GetMapping(path = "/all")
    public String getAllParticipant(Model model) {
        model.addAttribute("listParticipant", participantRepository.findAll());

        // Send to view
        return "participantsList";
    }
}
