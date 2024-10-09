package com.romedawg.listomania.controller;

import com.romedawg.listomania.LoadDatabase;
import com.romedawg.listomania.domain.Message;
import com.romedawg.listomania.domain.MessageInTransit;
import com.romedawg.listomania.domain.Person;
import com.romedawg.listomania.exception.CategoryNotFoundException;
import com.romedawg.listomania.exception.UserNotFoundException;
import com.romedawg.listomania.repository.MessageRepository;
import com.romedawg.listomania.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController()
class MessageController {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    MessageRepository messageRepository;
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @PostMapping("/list")
    public String PostMessage(@RequestBody MessageInTransit message){

        log.info("Create Message for " + message.getCategory() + " phoneNumber: " +  message.getPhoneNumber() + " item: " + message.getData());
        Integer personID = phoneNumberLookup(message.getPhoneNumber());

        message.setDateEntry(LocalTime.now());
        // if the active category is not set, set it to true by default.
        // maybe this should just be in the domain object(true by default) with the ability to update to false.
        if (!message.getActive()){
            message.setActive(true);
        };

        // User does not exist here
        if ((personID == 0)) {
            String ErrorMessage = String.format("%s does not exists, please sign up https://romedawg.com %n", message.getPhoneNumber());
            log.info(message.getPhoneNumber() + " does not exist");
            return ErrorMessage;
        }

        List<Person> personObject = personRepository.findPersonByPhoneNumberList(message.getPhoneNumber());
        log.debug("Creating a new message");
        Message saveMessage = new Message();
        saveMessage.setActive(message.getActive());
        saveMessage.setPerson(personObject.get(0));
        saveMessage.setCategory(message.getCategory());
        saveMessage.setData(message.getData());
        saveMessage.setDateEntry(LocalTime.now());
        saveMessage.setOwner(message.getOwner());

        messageRepository.save(saveMessage);
        log.info("message created for " + message.getPhoneNumber());
        return String.format("Success%n");

    }

    @GetMapping("/message/{category}")
    public String message(@PathVariable String category){
        List<String> list =  messageRepository.findMessagesByCategory(category);
        if (list.isEmpty()) {
            log.debug("category " + category + " not found");
            throw new CategoryNotFoundException(category);
        }
        return list.toString();
    }

    // Generic static category
    @GetMapping("/list")
    public String message(){
        List<String> list =  messageRepository.findMessagesByCategory("groceries");
        return list.toString();
    }

    private Integer phoneNumberLookup(String phoneNumber){

        log.info("FindPerson with phone number " + phoneNumber);
        Integer personLookup = personRepository.findPersonByPhoneNumber(phoneNumber);

        if (personLookup == null){
            log.debug("phone number not found: " + phoneNumber);
            return 0;
        };
        log.debug("phone number " + phoneNumber + " found");

        return personLookup;


    }
}
