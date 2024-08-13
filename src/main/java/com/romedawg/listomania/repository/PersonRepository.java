package com.romedawg.listomania.repository;

import com.romedawg.listomania.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT DISTINCT p.id, p.email FROM Person p WHERE p.phoneNumber=(:phoneNumber)")
    Person findPersonByPhoneNumber(@Param("phoneNumber") String category);
}
