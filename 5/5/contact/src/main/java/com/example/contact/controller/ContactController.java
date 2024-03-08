package com.example.contact.controller;


import com.example.contact.model.Contact;
import com.example.contact.data.ContactRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;

@Slf4j
@Controller
@RequestMapping(path = "/")
@SessionAttributes("contact")
public class ContactController {
    private ContactRepository contactRepository;

    @Autowired
    public ContactController( ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    ArrayList<Contact> contacts = new ArrayList<>();


    @ModelAttribute(name = "contact")
    public Contact contact(){return new Contact();}

    @ModelAttribute(name = "contacts")
    public ArrayList<Contact> contacts(){
        return contacts;
    }

    @GetMapping
    public String showHome(){
        return "home";
    }

    @PostMapping
    public String add(@Valid Contact contact, Errors errors, SessionStatus sessionStatus) {
        if(errors.hasErrors()){
            return "home";
        }

        contacts.add(contact);
        contactRepository.save(contact);
        log.info("Contact submitted: {}",contact);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
