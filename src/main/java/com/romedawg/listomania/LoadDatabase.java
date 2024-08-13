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

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(MessageRepository messageRepository, PersonRepository personRepository){
        LocalTime localTime = LocalTime.now();

        Person person = new Person("7082997663", "roman32@gmail.com");
        return args -> {
            log.info("Creating default user " + personRepository.save(person));
            log.info("Preloading Message Table" + messageRepository.save( new Message(person, "groceries", "bread", "rome", localTime, true)));

        };
    }
}

