package com.romedawg.listomania.controller;

import com.romedawg.listomania.LoadDatabase;
import com.romedawg.listomania.domain.Message;
import com.romedawg.listomania.domain.MessageBuilder;
import com.romedawg.listomania.domain.MessageInTransit;
import com.romedawg.listomania.domain.Person;
import com.romedawg.listomania.repository.MessageRepository;
import com.romedawg.listomania.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        if (message.getCategory() == null || message.getData() == null){
            String returnMessage = String.format("Category & Data cannot be null%n");
            logWrap(returnMessage);
            return returnMessage;
        }

        createMessages(message);
        logWrap("message created for " + message.getPhoneNumber());
        return String.format("Success%n");

    }

    @GetMapping("/list/{category}")
    public String message(@PathVariable String category){
        List<String> list =  messageRepository.findMessagesByCategory(category);
        if (list.isEmpty()) {
            String message = String.format("Category: %s does not exist%n", category);
            logWrap(message);
            return message;
        }
        return String.format("%s%n", list);
    }

    // Generic static category  // Should return list of categories(i.e groceries, costco, etc)
    @GetMapping("/{category}/{phoneNumber}")
    public String getMessage(@PathVariable String category, @PathVariable String phoneNumber){
        logWrap("look up a list by phone number");
        List<Person> personObject = personRepository.findPersonByPhoneNumberList(phoneNumber);
        if (personObject.isEmpty()) {
            String message =String.format("Phone number: %s does not exist%n", phoneNumber);
            logWrap(message);
            return String.format(message);
        }
        List<String> list =  messageRepository.findMessagesByCategoryPersonId(category, personObject.get(0).getId().intValue());
        return String.format("%s%n", list.toString());
    }

    // Return a list of categories for a phone number
    @GetMapping("/list_set/{phoneNumber}")
    public String getMyLists(@PathVariable String phoneNumber){
        logWrap("look type of lists by phone number");
        List<String> categoryList = personRepository.findCategoryByPhoneNumberList(phoneNumber);
        if (categoryList.isEmpty()) {
            String message =String.format("No categories for phone number: %s%n", phoneNumber);
            logWrap(message);
            return String.format(message);
        }
        return String.format("%s%n", categoryList);
    }


    // Utility functions
    /***
     *
     * @param phoneNumber
     * @return Integor - ID of the Person
     */
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

    private void createMessages(MessageInTransit message) {
        logWrap("Create Messages");

        log.debug("Creating a new message");
        List<Person> personObject = personRepository.findPersonByPhoneNumberList(message.getPhoneNumber());

        List<String> messageData = parseString(message.getData());

        for (String data : messageData) {
            Message messageCreate = MessageBuilder.builder()
                    .addData(data)
                    .addCategory(message.getCategory())
                    .addPerson(personObject.get(0)).build();
            messageRepository.save(messageCreate);
        }

    }

    // Parse list of items that are seperated by space/comma/newline char
    private List<String> parseString(String data){

        logWrap("Parse multiple data messages");

        return new ArrayList<>(Arrays.asList(data.split(",|\\s|\\n")));
    }

    private void logWrap(String message) {
        log.info("Message Controller: " + message);
    }
}
