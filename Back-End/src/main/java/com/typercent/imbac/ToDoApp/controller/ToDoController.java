package com.typercent.imbac.ToDoApp.controller;

import com.typercent.imbac.ToDoApp.entity.ToDo;
import com.typercent.imbac.ToDoApp.model.ToDoModel;
import com.typercent.imbac.ToDoApp.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService toDoService;

//    @GetMapping("/retrieveUncompleteToDo")
//    public ResponseEntity<List<ToDo>> getUncompleteToDo() {
//        return ResponseEntity.ok(this.toDoService.retrieveUncompleteToDoList());
//    }
//
//    @GetMapping("/retrieveCompleteToDo")
//    public ResponseEntity<List<ToDo>> getCompleteTodo() {
//        return ResponseEntity.ok((this.toDoService.retrieveCompleteToDoList()));
//    }

    @GetMapping("/retrieveAllToDo")
    public ResponseEntity<List<ToDo>> getAllToDo() {
        return ResponseEntity.ok(this.toDoService.retrieveAllToDoList());
    }

    @PostMapping("/createNewToDo")
    public ResponseEntity<ToDo> createNewToDo(@RequestBody ToDoModel request) {
        ToDo toDo = this.toDoService.createNewToDo(request);
        return new ResponseEntity<>(toDo, HttpStatus.CREATED);
    }

    @PutMapping("/updateToDo")
    public ResponseEntity<ToDo> updateToDo(@RequestBody ToDoModel request) {
        ToDo toDo = this.toDoService.updateToDo(request);
//        return ResponseEntity.created(null).build();
        return new ResponseEntity<>(toDo, HttpStatus.CREATED);
    }

    @PutMapping("/updateToDoStatus")
    public ResponseEntity<ToDo> updateToDoStatus(@RequestBody ToDoModel request) {
        ToDo toDo = this.toDoService.updateToDoStatus(request);
        return new ResponseEntity<>(toDo, HttpStatus.CREATED);
    }
}
