package com.romedawg.listomania.repository;

import com.romedawg.listomania.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT DISTINCT p.id FROM Person p WHERE p.phoneNumber=(:phoneNumber)")
    Integer findPersonByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    @Query("SELECT p FROM Person p WHERE p.phoneNumber=(:phoneNumber)")
    List<Person> findPerson(@Param("phoneNumber") String category);

//    @Query("SELECT p.phoneNumber, p.email FROM Person p WHERE p.phoneNumber=(:phoneNumber)")
//    List<Person> findPerson(@Param("phoneNumber") String category);
}
