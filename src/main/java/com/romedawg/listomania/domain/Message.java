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

    @ManyToOne()
    @JoinColumn(table = "message", name = "person_id", nullable = false)
    private Person person;

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
    public Message() {
        // empty constructor
    }

    public Message(Builder builder) {
        this.person = builder.user;
        this.category = builder.category;
        this.data = builder.data;
        this.owner = builder.owner;
        this.dateEntry = builder.dateEntry;
        this.active = builder.active;
    }

    public Message(Person user, String category, String data, String owner, LocalTime dateEntry, boolean active) {
        this.person = user;
        this.category = category;
        this.data = data;
        this.owner = owner;
        this.dateEntry = dateEntry;
        this.active = active;
    }

    public static final class Builder {
        private Person user;
        private String category;
        private String data;
        private LocalTime dateEntry;
        private String owner;
        private Boolean active;

        public Builder setUser(Person user) {
            this.user = user;
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

        public Message build(){
            return new Message(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
