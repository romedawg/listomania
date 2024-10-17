package com.romedawg.listomania.controller;

import com.romedawg.listomania.LoadDatabase;
import com.romedawg.listomania.domain.Message;
import com.romedawg.listomania.domain.MessageBuilder;
import com.romedawg.listomania.domain.MessageInTransit;
import com.romedawg.listomania.domain.Person;
import com.romedawg.listomania.exception.CategoryNotFoundException;
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

        // User does not exist here
        if ((personID == 0)) {
            String ErrorMessage = String.format("%s does not exists, please sign up https://romedawg.com %n", message.getPhoneNumber());
            logWrap(message.getPhoneNumber() + " does not exist");
            return ErrorMessage;
        }

        List<Person> personObject = personRepository.findPersonByPhoneNumberList(message.getPhoneNumber());
        log.debug("Creating a new message");
        Message messageCreate = MessageBuilder.builder()
                .addData(message.getData())
                .addCategory(message.getCategory())
                .addPerson(personObject.get(0)).build();

        messageRepository.save(messageCreate);
        logWrap("message created for " + message.getPhoneNumber());
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

    public Integer phoneNumberLookup(String phoneNumber){

        logWrap("FindPerson with phone number " + phoneNumber);
        Integer personLookup = personRepository.findPersonByPhoneNumber(phoneNumber);

        if (personLookup == null){
            log.debug("phone number not found: " + phoneNumber);
            return 0;
        };
        log.debug("phone number " + phoneNumber + " found");

        return personLookup;
    }

    public void logWrap(String message) {
        log.info("Message Create: " + message);
    }
}
