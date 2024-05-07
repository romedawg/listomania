package com.romedawg.listomania.repository;

import com.romedawg.listomania.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("SELECT m.data FROM Message m WHERE m.category=(:category)")
    Message findMessagesByCategory(@Param("category") String category);
}
