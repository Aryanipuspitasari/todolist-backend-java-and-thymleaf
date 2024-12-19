package com.example.todolist.service;
import com.example.todolist.repository.TodoRepository;
import com.example.todolist.model.TodoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<TodoModel> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<TodoModel> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public TodoModel saveTodo(TodoModel newTodo){
        return todoRepository.save(newTodo);
    }

    public void deleteToDo(Long id) {
        todoRepository.deleteById(id);
    }
}
