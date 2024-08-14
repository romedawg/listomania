package com.romedawg.listomania.controller;

import com.romedawg.listomania.LoadDatabase;
import com.romedawg.listomania.domain.Message;
import com.romedawg.listomania.exception.CategoryNotFoundException;
import com.romedawg.listomania.repository.MessageRepository;
import com.romedawg.listomania.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController()
class MessageController {

    private final MessageRepository messageRepository;
    private final PersonRepository personRepository;
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    MessageController(MessageRepository messageRepository, PersonRepository personRepository) {
        this.messageRepository = messageRepository;
        this.personRepository = personRepository;
    }

    @GetMapping("/message/{category}")
    public String message(@PathVariable String category){
        List<String> list =  messageRepository.findMessagesByCategory(category);
        if (list.isEmpty()) {
            log.info("category " + category + " not found");
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
    @PostMapping("/list")
    public String postMessage(@RequestBody Message message){
        message.setDateEntry(LocalTime.now());
        // if the active category is not set, set it to true by default.
        // maybe this should just be in the domain object(true by default) with the ability to update to false.
        if (!message.getActive()){
            message.setActive(true);
        };

        messageRepository.save(message);
        return "success";
    }

    private String personLookup(String phoneNumber){

        personRepository.findPersonByPhoneNumber(phoneNumber);

        return "";

    }

}
