package com.todo.todo_application.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.todo.todo_application.dto.Task;
import com.todo.todo_application.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	TaskRepository repository;

	public List<Task> getAllTasks() {
		return repository.findAll();
	}

	public void saveRecored(String title) {
		Task task = new Task();
		task.setTitle(title);
		task.setCompleted(false);
		repository.save(task);
	}

	public void delete(int id) {
		repository.deleteById(id);
	}

	public void completed(int id) {
		Task task = repository.findById(id).orElseThrow();
		task.setCompleted(!task.isCompleted());
		repository.save(task);
	}

}
