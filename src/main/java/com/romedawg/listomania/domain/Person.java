package com.romedawg.listomania.domain;

import jakarta.persistence.*;

@Entity
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", nullable = false)
    private Long id;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    public Person(String phoneNumber, String email) {
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public Person(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
