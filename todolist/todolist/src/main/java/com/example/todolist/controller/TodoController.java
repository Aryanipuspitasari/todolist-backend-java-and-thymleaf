package com.example.todolist.controller;

import com.example.todolist.model.TodoModel;
import com.example.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/todos")
public class TodoController {
    
    @Autowired
    private TodoService todoService;

    // extract all todos
    @GetMapping
    public String getAllTodos(Model model){
        model.addAttribute("todos", todoService.getAllTodos());
        return "todo-list"; // this is my thymleaf template
    }
    
    // extract todo based on id
    @GetMapping("/{id}")
     public String getTodoById(@PathVariable("id") Long id, Model model) {
        // model.addAttribute("todo", todoService.getTodoById(id).orElseThrow());
        // return "todo-details";
        
        TodoModel todo = todoService.getTodoById(id).orElseThrow(() -> new RuntimeException("Todo Not Found"));
        model.addAttribute("todo", todo);
        return "todo-details";

    }

    // saving new todo

    @PostMapping
    public String saveTodo(@ModelAttribute TodoModel toDo) {
        todoService.saveTodo(toDo);
        return "redirect:/todos"; // Redirect ke daftar todo setelah menyimpan
    }
    
    //remove todo based on id
    @DeleteMapping("/{id}")
    public String deleteToDo(@PathVariable("id") Long id) {
        todoService.deleteToDo(id);
        return "redirect:/todos"; // Redirect ke daftar todo setelah menyimpan
    }
}
