package com.romedawg.listomania;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ListomaniaApplication {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);


	public static void main(String[] args) {
		SpringApplication.run(ListomaniaApplication.class, args);

		log.info("I'm alive");
	}

}
