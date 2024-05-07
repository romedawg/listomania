package com.romedawg.listomania.controller;

import com.romedawg.listomania.repository.MessageRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController()
class MessageController {

    private final MessageRepository messageRepository;

    MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

//    @GetMapping("/category")
//    public Message message(@PathVariable String category){
//        return messageRepository.findMessagesByCategory("groceries");
//    }

    @GetMapping("/category")
    public String message(){
        return "testing";
    }
}
