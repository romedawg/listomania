package com.romedawg.listomania;

import com.romedawg.listomania.domain.Message;
import com.romedawg.listomania.domain.Person;
import com.romedawg.listomania.repository.MessageRepository;
import com.romedawg.listomania.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    // Preloading data to have something to work with
//    @Bean
//    CommandLineRunner initDatabase(MessageRepository messageRepository, PersonRepository personRepository){
//        LocalTime localTime = LocalTime.now();
//
//        String phoneNumber = "7081234567";
//        String email = "JackBurton@gmail.com";
//        Integer personLookup = personRepository.findPersonByPhoneNumber(phoneNumber);
//        Person person = new Person(phoneNumber,email);
//
//        if (Optional.ofNullable(personLookup).orElse(0) == 0){
//            log.info("user does not exist, adding them now");
//            personRepository.save(person);
//        }else {
//            log.info("DEFAULT USER EXISTS, SKIPPING : " + personLookup);
//        }
//
//        List<Person> personObject = personRepository.findPerson(phoneNumber);
//        return args -> {
//            log.info("Preloading Message Table" + messageRepository.save( new Message(personObject.get(0), "groceries", "bread", "rome", localTime, true)));
//        };
//    }
}

