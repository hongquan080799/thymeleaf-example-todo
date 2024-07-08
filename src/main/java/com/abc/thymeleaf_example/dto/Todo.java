package com.abc.thymeleaf_example.dto;

import java.util.Arrays;
import java.util.UUID;

public class Todo {
    public enum TodoStatus {
        NEW("new"),
        WORKING("working"),
        DONE("done"),
        CANCEL("cancel");

        private String status;

        TodoStatus(String status) {
            this.status = status;
        }
        public String getStatus() {
            return status;
        }

    }
    private String id;
    private String todoTask;
    private TodoStatus status;


    public String getTodoTask() {
        return todoTask;
    }

    public void setTodoTask(String todoTask) {
        this.todoTask = todoTask;
    }

    public TodoStatus getStatus() {
        return status;
    }

    public void setStatus(TodoStatus status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
