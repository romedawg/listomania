package com.romedawg.listomania.domain;

public class PersonBuilder {

    private Person person;

    public PersonBuilder() {
        this.person = new Person();
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public Person build() {
        return this.person;
    }

    public PersonBuilder addPhoneNumber(String phoneNumber) {
        this.person.setPhoneNumber(phoneNumber);
        return this;
    }

    public PersonBuilder addEmail(String email) {
        this.person.setEmail(email);
        return this;
    }
}
