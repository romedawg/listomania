package com.romedawg.listomania.domain;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name="message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    protected Message() {
        // empty constructor
    }

    protected Message(Person person, String category, String data, String owner, boolean active) {
        this.person = person;
        this.category = category;
        this.data = data;
        this.owner = owner;
        this.active = active;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPersonId() {
        return Math.toIntExact(person.getId());
    }

    public Person getPerson() {
        return person;
    }

    protected void setPerson(Person person) {
        this.person = person;
    }

    public String getCategory() {
        return category;
    }

    protected void setCategory(String category) {
        this.category = category;
    }

    public String getData() {
        return data;
    }

    protected void setData(String data) {
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

    public void setDateEntry(LocalTime time) {
        this.dateEntry = time;
    }

    public boolean getActive() {
        return active;
    }

    protected void setActive(boolean active) {
        this.active = active;
    }
}
