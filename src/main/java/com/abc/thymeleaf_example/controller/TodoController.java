package com.abc.thymeleaf_example.controller;

import com.abc.thymeleaf_example.dto.Todo;
import com.abc.thymeleaf_example.dto.Todo.TodoStatus;
import com.abc.thymeleaf_example.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping("/")
    public String indexPage() {
        return "redirect:/todo";
    }

    @GetMapping("/todo/update/{id}")
    public String updateTodoForm(@PathVariable String id, Model model) {
        Todo todo = service.getTodoById(id);
        model.addAttribute("statusList", TodoStatus.values());
        model.addAttribute("header", "TODO LIST");
        model.addAttribute("description", "Make your life easier");
        model.addAttribute("todos", service.getTodoList());
        model.addAttribute("todo", todo);
        return "index";
    }

    @GetMapping("/todo")
    public String todoPage(Model model) {
        model.addAttribute("statusList", TodoStatus.values());
        model.addAttribute("header", "TODO LIST");
        model.addAttribute("description", "Make your life easier");
        model.addAttribute("todos", service.getTodoList());

        Todo todo = new Todo();
        todo.setId(UUID.randomUUID().toString());
        model.addAttribute("todo", todo);

        return "index";
    }

    @PostMapping("/todo")
    public String addTodo(@ModelAttribute Todo todo) {
        if (todo.getStatus() == null) {
            todo.setStatus(TodoStatus.NEW); // Set default status to NEW
        }
        service.insertOrUpdateTodo(todo);
        return "redirect:/todo";
    }


    @GetMapping("/todo/delete/{id}")
    public String deleteTodo(@PathVariable("id") String id) {
        service.deleteToDo(id);
        return "redirect:/todo";
    }
}
