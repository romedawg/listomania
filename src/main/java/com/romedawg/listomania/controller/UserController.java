package com.romedawg.listomania.controller;

import com.romedawg.listomania.domain.Person;
import com.romedawg.listomania.domain.View;
import com.romedawg.listomania.LoadDatabase;
import com.romedawg.listomania.domain.PersonBuilder;
import com.romedawg.listomania.repository.PersonRepository;

import com.fasterxml.jackson.annotation.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class UserController {

    @Autowired
    private final PersonRepository personRepository;

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);


    public UserController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @JsonView(View.PersonView.class)
    @GetMapping("/user/{phoneNumber}")
    public List<Person> getUser(@PathVariable String phoneNumber){

        Integer personID = personRepository.findPersonByPhoneNumber(phoneNumber);

        if (personID == null){
            String message = String.format("Phone number: %s does not exist%n", phoneNumber);
            logWrap(message);
            return null;
        }
        List<Person> person = personRepository.findPersonByPhoneNumberList(phoneNumber);
        return person;
    }

    @PostMapping("/user")
    public String createUser(@RequestBody Person person){
        Integer personID = personRepository.findPersonByPhoneNumber(person.getPhoneNumber());

        if (personID != null){
            String returnMessage = String.format("Phone number: %s already exists%n", person.getPhoneNumber());
            logWrap(returnMessage);
            return returnMessage;
        }

        logWrap("Creating new user with phone number: " + person.getPhoneNumber());
        personRepository.save(PersonBuilder.builder().addPhoneNumber(person.getPhoneNumber()).addEmail(person.getEmail()).build());

        return String.format("success %n");
    }

    public void logWrap(String message) {
        log.info("User Create: " + message);
    }

    @JsonView(View.PersonView.class)
    @GetMapping("/users")
    public List<Person> getUsers(){
        return personRepository.findAll();
    }
}
