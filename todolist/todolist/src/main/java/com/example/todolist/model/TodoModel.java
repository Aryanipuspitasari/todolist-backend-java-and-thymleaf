package com.example.todolist.model;

import jakarta.persistence.*;

@Entity
@Table(name = "todos")
public class TodoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "task", nullable = false)
    private String title;

    @Column(name = "completed", nullable = false)
    private boolean completed;

    // Default constructor
    public TodoModel() {}

    // Getter dan setter untuk id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Getter dan setter untuk title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter dan setter untuk completed
    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // Metode untuk menetapkan default value
    @PrePersist
    public void setDefaultValues() {
        this.completed = false;
    }
}
