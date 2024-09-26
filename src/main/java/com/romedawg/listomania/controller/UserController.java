package com.romedawg.listomania.controller;

import com.romedawg.listomania.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class UserController {


    private final PersonRepository personRepository;

    public UserController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/user/{phoneNumber}")
    public String getUser(@PathVariable String phoneNumber){
        Integer personID = personRepository.findPersonByPhoneNumber(phoneNumber);
        return "ID: " + personID.toString() + "Email: " ;
    }
}
