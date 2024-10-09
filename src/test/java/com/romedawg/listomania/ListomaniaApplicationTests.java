package com.romedawg.listomania;

import com.romedawg.listomania.domain.Message;
import com.romedawg.listomania.domain.Person;
import com.romedawg.listomania.repository.MessageRepository;
import com.romedawg.listomania.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalTime;
import java.util.List;


@AutoConfigureJsonTesters
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class ListomaniaApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Autowired
    MockMvc mvc;

//    @MockBean
    @Autowired
    private MessageRepository messageRepository;
//    @MockBean
    @Autowired
    private PersonRepository personRepository;

    @Test
    void addUser(){
        String phoneNumber = "1234567890";
        String email = "ArtVandalay@gmail.com";
        Person person = new Person(phoneNumber,email);
        personRepository.save(person);
    }

//    @Test
//    void checkUserExists() throws Exception{
//        String phoneNumber = "1234567890";
//
//    }

//	@Test
//	void addMessage() {
//        LocalTime localTime = LocalTime.now();
//        String phoneNumber = "1234567890";
//        List<Person> personLookup = personRepository.findPersonByPhoneNumberList(phoneNumber);
//        messageRepository.save( new Message(personLookup.get(0), "groceries", "bread", "rome", localTime, true));
//	}





}
