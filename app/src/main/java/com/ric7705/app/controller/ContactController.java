package com.ric7705.app.controller;


import com.ric7705.app.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/contact")
@CrossOrigin(value = "http://localhost:4200")
public class ContactController {

    @Autowired
    ContactService contactService;


    @GetMapping(value = "/{user}")
    public List<String> getUserContact(@PathVariable String user){
        return contactService.getContactByUser(user);
    }
}
