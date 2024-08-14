package com.romedawg.listomania;

import com.romedawg.listomania.domain.Message;
import com.romedawg.listomania.domain.Person;
import com.romedawg.listomania.repository.MessageRepository;
import com.romedawg.listomania.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalTime;
import java.util.Optional;
@SpringBootTest
@ActiveProfiles("test")
class ListomaniaApplicationTests {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MessageRepository messageRepository;

	@Test
	void domainPersists() {

        LocalTime localTime = LocalTime.now();
        String phoneNumber = "70812344567";
        String email = "JackBurton@gmail.com";
        Person person = new Person(phoneNumber,email);
        personRepository.save(person);

        messageRepository.save( new Message(person, "groceries", "bread", "rome", localTime, true));
	}

}
