package com.romedawg.listomania.domain;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;


@Entity
@Table(name="person")
public class Person {

    @ManyToOne
    @JoinColumn(name = "person_person_id")
    public Person person;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", nullable = false)
    private Long id;

    @JsonView(View.PersonView.class)
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @JsonView(View.PersonView.class)
    @Column(name = "email", nullable = false)
    private String email;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person(String phoneNumber, String email) {
        this.phoneNumber = phoneNumber;
        this.email = email;

    }
    public Person(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Protected constructor for the JPA framework.
     * <p>
     * Note: This constructor is not intended to be used directly.
     * </p>
     */
    protected Person() {}

    protected void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    protected void setEmail(String email) { this.email = email; }

    public Long getId() { return id;}

    /**
     * Gets the phone number for this person.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets the email for this person.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

}
