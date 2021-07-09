package com.typercent.imbac.Todo.controller;

import com.typercent.imbac.Todo.entity.Todo;
import com.typercent.imbac.Todo.model.TodoDTO;
import com.typercent.imbac.Todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

//    @GetMapping("/retrieveUncompleteToDo")
//    public ResponseEntity<List<ToDo>> getUncompleteToDo() {
//        return ResponseEntity.ok(this.toDoService.retrieveUncompleteToDoList());
//    }
//
//    @GetMapping("/retrieveCompleteToDo")
//    public ResponseEntity<List<ToDo>> getCompleteTodo() {
//        return ResponseEntity.ok((this.toDoService.retrieveCompleteToDoList()));
//    }

    @GetMapping("/retrieveAllTodo")
    public ResponseEntity<List<Todo>> getAllToDo() {
        return ResponseEntity.ok(this.todoService.retrieveAllToDoList());
    }

    @PostMapping("/createNewTodo")
    public ResponseEntity<Todo> createNewToDo(@RequestBody TodoDTO request) {
        Todo toDo = this.todoService.createNewToDo(request);
        return new ResponseEntity<>(toDo, HttpStatus.CREATED);
    }

    @PutMapping("/updateTodo")
    public ResponseEntity<Todo> updateToDo(@RequestBody TodoDTO request) {
        Todo toDo = this.todoService.updateToDo(request);
        return new ResponseEntity<>(toDo, HttpStatus.CREATED);
    }

    @PutMapping("/updateTodoStatus/{id}")
    public ResponseEntity<Todo> updateToDoStatus(@PathVariable Long id) {
        Todo toDo = this.todoService.updateToDoStatus(id);
        return new ResponseEntity<>(toDo, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTodo(@PathVariable("id") Long id) {
        this.todoService.deleteTodo(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllTodo() {
        this.todoService.deleteAllCompleteTodo();
    }
}
