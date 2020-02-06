/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.ensg.Projet_Spring_Hibernate.controller;

import eu.ensg.Projet_Spring_Hibernate.model.Participant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // This means that this class is a Controller
@RequestMapping(path="/") // This means URL's start with /demo (after Application path)
public class MainController {
    
    @GetMapping(path = "/index")
    public String index(Model model) {
        // Send to view
        return "index";
    }
    
    @GetMapping(path = "/addParticipant")
    public String addParticipantPage(Model model) {
        Participant newParticipant = new Participant();
        model.addAttribute("newParticipant", newParticipant);
        // Send to view
        return "addParticipant";
    }
}
