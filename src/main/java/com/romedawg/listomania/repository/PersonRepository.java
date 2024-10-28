package com.romedawg.listomania.repository;

import com.romedawg.listomania.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT DISTINCT p.id FROM Person p WHERE p.phoneNumber=(:phoneNumber)")
    Integer findPersonByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    @Query("SELECT DISTINCT p.id FROM Person p WHERE p.id=(:user_id)")
    List<Person> findPersonById(@Param("user_id") Integer user_id);

    @Query("SELECT p FROM Person p WHERE p.phoneNumber=(:phoneNumber)")
    List<Person> findPersonByPhoneNumberList(@Param("phoneNumber") String phoneNumber);

    @Query("SELECT m.category FROM Message m JOIN Person p ON m.person.id=p.id WHERE p.phoneNumber=(:phoneNumber)")
    List<String> findCategoryByPhoneNumberList(@Param("phoneNumber") String phoneNumber);
}
