package com.typercent.imbac.ToDoApp.repository;

import com.typercent.imbac.ToDoApp.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepo extends JpaRepository<ToDo, Long> {
    List<ToDo> findByToDoStatus(boolean b);
}
