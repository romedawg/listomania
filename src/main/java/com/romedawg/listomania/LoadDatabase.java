package com.romedawg.listomania;

import com.romedawg.listomania.domain.Message;
import com.romedawg.listomania.repository.MessageRepository;
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
    CommandLineRunner initDatabase(MessageRepository messageRepository){
        LocalTime localTime = LocalTime.now();
        return args -> {
            log.info("Preloading Message Table" + messageRepository.save( new Message("7082997663", "groceries", "bread", "rome", localTime, true)));
        };
    }
}
