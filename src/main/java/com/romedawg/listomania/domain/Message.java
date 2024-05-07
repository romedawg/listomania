package com.romedawg.listomania.domain;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name="message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "data", nullable = false)
    private String data;

    @Column(name = "owner", nullable = true)
    private String owner;

    @Column(name = "date_entry", nullable = false)
    private LocalTime dateEntry;

    @Column(name = "active", nullable = false)
    private boolean active;

    public Message(String phoneNumber, String category, String data, String owner, LocalTime dateEntry, boolean active) {
        this.phoneNumber = phoneNumber;
        this.category = category;
        this.data = data;
        this.owner = owner;
        this.dateEntry = dateEntry;
        this.active = active;
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

    public LocalTime getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(LocalTime dateEntry) {
        this.dateEntry = dateEntry;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
