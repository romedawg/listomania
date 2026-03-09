package com.romedawg.listomania.controller;

import com.romedawg.listomania.LoadDatabase;
import com.romedawg.listomania.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.json.JSONObject;

@RestController()
class HealthController {

    @Autowired
    MessageRepository messageRepository;
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @GetMapping("/health")
    public String GetHealth(){

        log.info("Healthcheck Controller");

        // User does not exist here
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("healthcheck", "healthy");
        return jsonObject.toString();

    }

}
