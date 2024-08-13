package com.romedawg.listomania.repository;

import com.romedawg.listomania.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("SELECT DISTINCT m.data FROM Message m WHERE m.category=(:category)")
    List<String> findMessagesByCategory(@Param("category") String category);
}
