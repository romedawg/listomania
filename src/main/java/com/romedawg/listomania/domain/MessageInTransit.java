package com.romedawg.listomania.domain;

import jakarta.persistence.*;

import java.time.LocalTime;

public class MessageInTransit {

    private Long id;

    private String phoneNumber;

    private String category;

    private String data;

    private String owner;


    /***
     * Constructor.
     */
    public MessageInTransit() {
        // empty constructor
    }

    public MessageInTransit(String phoneNumber, String category, String data, String owner) {
        this.phoneNumber = phoneNumber;
        this.category = category;
        this.data = data;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}
