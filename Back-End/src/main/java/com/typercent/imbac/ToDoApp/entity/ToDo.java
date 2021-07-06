package com.typercent.imbac.ToDoApp.entity;

import com.typercent.imbac.ToDoApp.core.AppFlagStatus;
import com.typercent.imbac.ToDoApp.core.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class ToDo extends BaseEntity {

    @Column(name = "ToDo", nullable = false)
    private String toDo;

    @Column(name = "ToDoStatus")
    private Boolean toDoStatus = AppFlagStatus.IS_COMPLETED_FLAG.N;
}
