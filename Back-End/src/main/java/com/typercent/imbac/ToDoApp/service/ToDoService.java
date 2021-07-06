package com.typercent.imbac.ToDoApp.service;

import com.typercent.imbac.ToDoApp.core.AppFlagStatus;
import com.typercent.imbac.ToDoApp.entity.ToDo;
import com.typercent.imbac.ToDoApp.exception.DataNotFoundException;
import com.typercent.imbac.ToDoApp.model.ToDoModel;
import com.typercent.imbac.ToDoApp.repository.ToDoRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepo toDoRepo;

    //create
    public void createNewToDo(ToDoModel request){
        log.info("createNewToDo: {}", request);
        ToDo toDo = new ToDo();
        toDo.setCreatedDate(LocalDateTime.now());
        toDo.setToDo(request.getToDo());
        this.toDoRepo.save(toDo);
    }

    //read
    public List<ToDo> retrieveAllToDoList() {
        log.info("retrieveAllToDoList");
        return this.toDoRepo.findAll();
    }

    public List<ToDo> retrieveToDoList() {
        log.info("retrieveToDoList");
        return this.toDoRepo.findByToDoStatus(false);
    }

    //update
    public void updateToDo(ToDoModel request) {
        log.info("updateNewToDo: {}", request);
        ToDo toDo = this.toDoRepo.findById(request.getId())
                .orElseThrow(() -> new DataNotFoundException("Can't update 'Cause this id " + request.getId() + " does not exist in Todo"));
        toDo.setToDo(request.getToDo());
        toDo.setUpdateddDate(LocalDateTime.now());
        this.toDoRepo.save(toDo);
    }

    public void updateToDoStatus(ToDoModel request) {
        log.info("updateNewToDo: {}", request);
        ToDo toDo = this.toDoRepo.findById(request.getId())
                .orElseThrow(() -> new DataNotFoundException("Can't update 'Cause this id " + request.getId() + " does not exist in Todo"));
        toDo.setToDoStatus(AppFlagStatus.IS_COMPLETED_FLAG.Y);
        toDo.setUpdateddDate(LocalDateTime.now());
        this.toDoRepo.save(toDo);
    }
}
