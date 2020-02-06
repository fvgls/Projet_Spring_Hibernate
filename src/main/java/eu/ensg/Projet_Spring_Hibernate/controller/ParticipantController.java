/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.ensg.Projet_Spring_Hibernate.controller;

import eu.ensg.Projet_Spring_Hibernate.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/participant") // This means URL's start with /demo (after Application path)
public class ParticipantController {

    @Autowired
    private ParticipantRepository participantRepository;

    
    
    @PostMapping(path = "/create") // Map ONLY POST Requests
    public @ResponseBody
    String createNewParticipant(@RequestParam String name,
             @RequestParam String email, Model model) {

        Participant p = new Participant();
        p.setName(name);
        p.setEmail(email);
        participantRepository.save(p);

        model.addAttribute("participant", p);

        return "createParticipant";
    }
    
    

    @PostMapping(path = "/addParticipant") // Map ONLY POST Requests
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

    
    
    @GetMapping(path = "/all")
    public String getAllParticipant(Model model) {
        model.addAttribute("listParticipant", participantRepository.findAll());

        // Send to view
        return "participantsList";
    }
}
