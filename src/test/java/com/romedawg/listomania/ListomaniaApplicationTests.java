package com.romedawg.listomania;

import com.romedawg.listomania.domain.Message;
import com.romedawg.listomania.domain.Person;
import com.romedawg.listomania.repository.MessageRepository;
import com.romedawg.listomania.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalTime;
@SpringBootTest
@ActiveProfiles("test")
class ListomaniaApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MessageRepository messageRepository;

	@Test
	void domainPersists() {

        LocalTime localTime = LocalTime.now();
        String phoneNumber = "1234567890";
        String email = "ArtVandalay@gmail.com";
        Person person = new Person(phoneNumber,email);
        personRepository.save(person);

        log.info("TESTING inserting some data into messages");
        messageRepository.save( new Message(person, "groceries", "bread", "rome", localTime, true));
	}

}
