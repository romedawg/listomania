package com.romedawg.listomania.domain;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name="message_in_transit")
public class MessageInTransit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

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

    /***
     * Constructor.
     */
    public MessageInTransit() {
        // empty constructor
    }

    public MessageInTransit(Builder builder) {
        this.phoneNumber = builder.build().phoneNumber;
        this.category = builder.category;
        this.data = builder.data;
        this.owner = builder.owner;
        this.dateEntry = builder.dateEntry;
        this.active = builder.active;
    }

    public MessageInTransit(String phoneNumber, String category, String data, String owner, LocalTime dateEntry, boolean active) {
        this.phoneNumber = phoneNumber;
        this.category = category;
        this.data = data;
        this.owner = owner;
        this.dateEntry = dateEntry;
        this.active = active;
    }

    public static final class Builder {
        private String phoneNumber;
        private String category;
        private String data;
        private LocalTime dateEntry;
        private String owner;
        private Boolean active;

        public Builder setUser(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setcategory(String category) {
            this.category = category;
            return this;
        }

        public Builder setData(String data) {
            this.data = data;
            return this;
        }

        public Builder setdateEntry(LocalTime dateEntry) {
            this.dateEntry = dateEntry;
            return this;
        }

        public Builder setOwner(String owner) {
            this.owner = owner;
            return this;
        }

        public Builder setActive(Boolean active) {
            this.active = active;
            return this;
        }

        public MessageInTransit build(){
            return new MessageInTransit(this);
        }
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
