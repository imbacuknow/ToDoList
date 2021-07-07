package com.typercent.imbac.Todo.repository;

import com.typercent.imbac.Todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Long> {

    List<Todo> findByIsComplete(Boolean b);
}
