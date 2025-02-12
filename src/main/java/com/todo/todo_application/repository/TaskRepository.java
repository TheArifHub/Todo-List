package com.todo.todo_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.todo_application.dto.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
