package com.typercent.imbac.Todo.exception;

import lombok.Data;

@Data
public class DataNotFoundException extends RuntimeException{

    private String errorCode = "ERROR001";
    private String error;

    public DataNotFoundException(String msg) {
        super(msg);
    }
}
