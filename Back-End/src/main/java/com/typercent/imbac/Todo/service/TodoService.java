package com.typercent.imbac.Todo.service;

import com.typercent.imbac.Todo.core.AppFlag;
import com.typercent.imbac.Todo.entity.Todo;
import com.typercent.imbac.Todo.exception.DataNotFoundException;
import com.typercent.imbac.Todo.model.TodoDTO;
import com.typercent.imbac.Todo.repository.TodoRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepo todoRepo;

    // -------------- create --------------
    public Todo createNewToDo(TodoDTO request){
        log.info("createNewToDo: {}", request);
        Todo toDo = new Todo();
        toDo.setCreatedDate(LocalDateTime.now());
        toDo.setTitle(request.getTitle());
        return this.todoRepo.save(toDo);
    }

    // -------------- read --------------
    public List<Todo> retrieveAllToDoList() {
        log.info("retrieveAllToDoList");
        return this.todoRepo.findAll();
    }

    public List<Todo> retrieveUncompleteToDoList() {
        log.info("retrieveUncompleteToDoList");
        return this.todoRepo.findByIsComplete(false);
    }

    public List<Todo> retrieveCompleteToDoList() {
        log.info("retrieveCompleteToDoList");
        return this.todoRepo.findByIsComplete(true);
    }

    // -------------- update --------------
    public Todo updateToDo(TodoDTO request) {/**/
        log.info("updateNewToDo: {}", request);
        Todo todo = this.todoRepo.findById(request.getId())
                .orElseThrow(() -> new DataNotFoundException("Can't update 'Cause this id " + request.getId() + " does not exist in Todo"));
        todo.setTitle(request.getTitle());
        todo.setUpdateddDate(LocalDateTime.now());
        return this.todoRepo.save(todo);
    }

    public Todo updateToDoStatus(Long id) {
        log.info("updateNewToDo: id={}", id);
        Todo todo = this.todoRepo.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Can't update 'Cause this id " + id + " does not exist in Todo"));
        todo.setIsComplete(AppFlag.IS_COMPLETED_FLAG.Y);
        todo.setUpdateddDate(LocalDateTime.now());
        return this.todoRepo.save(todo);
    }

    // -------------- delete --------------
    public void deleteTodo(Long id) {
        log.info("deleteTodo: id={}", id);
        Todo todo = this.todoRepo.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Can't delete 'Cause this id " + id + " does not exist in Todo"));
        this.todoRepo.deleteById(id);
    }

    public void deleteAllCompleteTodo() {
        log.info("deleteAllCompleteTodo");
        List<Todo> todoList = this.todoRepo.findByIsComplete(true);
        this.todoRepo.deleteAll(todoList);
    }
}
