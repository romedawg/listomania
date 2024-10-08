package com.romedawg.listomania.controller;

import com.romedawg.listomania.LoadDatabase;
import com.romedawg.listomania.domain.Person;
import com.romedawg.listomania.exception.UserNotFoundException;
import com.romedawg.listomania.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/user/{phoneNumber}")
    public String getUser(@PathVariable String phoneNumber){

        Integer personID = personRepository.findPersonByPhoneNumber(phoneNumber);

        if (personID == null){
            String message = String.format("Phone number: %s does not exist%n", phoneNumber);
            log.info(message);
            return message;
        }
        List<Person> person = personRepository.findPersonByPhoneNumberList(phoneNumber);
        return String.format("Phone number: %s Email: %s %n",  person.get(0).getPhoneNumber(),  person.get(0).getEmail() );
    }


    @PostMapping("/user")
    public String createUser(@RequestBody Person person){
        Integer personID = personRepository.findPersonByPhoneNumber(person.getPhoneNumber());

        if (personID != null){
            log.info("Phone Number: " + person.getPhoneNumber() + " already exists");
            return "Phone Number: " + person.getPhoneNumber() + " already exists";
        }

        log.info("Creating Person for phone number: " + person.getPhoneNumber());
        personRepository.save(new Person(person.getPhoneNumber(), person.getEmail()));

        return "success";
    }
}
