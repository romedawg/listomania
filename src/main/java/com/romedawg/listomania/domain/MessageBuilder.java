package com.romedawg.listomania.domain;

import java.time.LocalTime;

public class MessageBuilder {

    private Message message;
    private Person person;

    public MessageBuilder() {
        this.message = new Message();
        message.setDateEntry(LocalTime.now());
        message.setActive(true);
    }

    public static MessageBuilder builder(){
        return new MessageBuilder();
    }

    public Message build() {
        return this.message;
    }

    public MessageBuilder addPerson(Person person) {
       message.setPerson(person);
       return this;
    }

    public MessageBuilder addCategory(String category) {
        message.setCategory(category);
        return this;
    }

    public MessageBuilder addData(String data) {
        message.setData(data);
        return this;
    }

    public MessageBuilder addOwner(String owner) {
        message.setOwner(owner);
        return this;
    }



}
