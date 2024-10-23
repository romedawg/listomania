package com.romedawg.listomania.repository;

import com.romedawg.listomania.domain.Message;
import com.romedawg.listomania.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    // Working previously
    @Query("SELECT DISTINCT m.data FROM Message m WHERE m.category=(:category)")
    List<String> findMessagesByCategory(@Param("category") String category);

    @Query("SELECT DISTINCT m.data FROM Message AS m JOIN Person AS p ON m.person.id=p.id WHERE m.category=(:category) AND m.person.id=(:person_id)")
    List<String> findMessagesByCategoryPersonId(@Param("category") String category, @Param("person_id") Integer person_id);
}

//    select distinct message.data from message person JOIN message ON message.person_id=person.id WHERE message.category='groceries' AND message.person_id=3
//    select distinct m.data from message AS m JOIN person AS p ON m.person_id=p.person_id WHERE m.category='groceries' AND m.person_id=3;
