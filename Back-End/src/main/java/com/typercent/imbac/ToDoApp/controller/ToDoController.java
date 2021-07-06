package com.typercent.imbac.ToDoApp.controller;

import com.typercent.imbac.ToDoApp.entity.ToDo;
import com.typercent.imbac.ToDoApp.model.ToDoModel;
import com.typercent.imbac.ToDoApp.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService toDoService;

    @GetMapping("/retrieveUncompleteToDo")
    public ResponseEntity<List<ToDo>> getUncompleteToDo() {
        return ResponseEntity.ok(this.toDoService.retrieveToDoList());
    }

    @GetMapping("/retrieveAllToDo")
    public ResponseEntity<List<ToDo>> getAllToDo() {
        return ResponseEntity.ok(this.toDoService.retrieveAllToDoList());
    }

    @PostMapping("/createNewToDo")
    public void createNewToDo(@RequestBody ToDoModel request) {
        this.toDoService.createNewToDo(request);
    }

    @PutMapping("/updateToDo")
    public void updateToDo(@RequestBody ToDoModel request) {
        this.toDoService.updateToDo(request);
    }

    @PutMapping("/updateToDoStatus")
    public void updateToDoStatus(@RequestBody ToDoModel request) {
        this.toDoService.updateToDoStatus(request);
    }
}
