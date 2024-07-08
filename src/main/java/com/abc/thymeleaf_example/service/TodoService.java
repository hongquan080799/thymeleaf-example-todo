package com.abc.thymeleaf_example.service;

import com.abc.thymeleaf_example.dto.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TodoService {
    private Map<String, Todo> list = new ConcurrentHashMap<>();

    public TodoService () {
        Todo todo = new Todo();
        todo.setId(UUID.randomUUID().toString());
        todo.setTodoTask("test");
        todo.setStatus(Todo.TodoStatus.NEW);
        list.put(todo.getId(), todo);
    }

    public List<Todo> getTodoList () {
        return list.values().stream().toList();
    }

    public List<Todo> insertOrUpdateTodo (Todo todo) {
        list.put(todo.getId(), todo);
        return getTodoList();
    }
    public List<Todo> deleteToDo (String id) {
        list.remove(id);
        return getTodoList();
    }

    public Todo getTodoById (String id) {
        return list.get(id);
    }

}
