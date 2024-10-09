//package com.romedawg.listomania.utility;
//
//import com.romedawg.listomania.LoadDatabase;
//import com.romedawg.listomania.domain.Person;
//import com.romedawg.listomania.repository.MessageRepository;
//import com.romedawg.listomania.repository.PersonRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class Validate {
//
//
//    @Autowired
//    static
//    PersonRepository personRepository;
//    MessageRepository messageRepository;
//    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
//
//    public static Integer PhoneNumberLookup(String phoneNumber){
//
//        log.info("Find person with phone number " + phoneNumber);
//        List<Person> personLookup = personRepository.findPersonByPhoneNumberList(phoneNumber);
//
//        if (personLookup.get(0).getId() == 0){
//            log.debug("phone number not found: " + phoneNumber);
//            return 0;
//        };
//        log.debug("phone number " + phoneNumber + " found");
//
//        return Math.toIntExact(personLookup.get(0).getId());
//
//
//    }
//}
