package com.typercent.imbac.Todo.entity;

import com.typercent.imbac.Todo.core.AppFlag;
import com.typercent.imbac.Todo.core.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Todo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ToDo", nullable = false)
    private String title;

    @Column(name = "ToDoStatus")
    private Boolean isComplete = AppFlag.IS_COMPLETED_FLAG.N;
}
