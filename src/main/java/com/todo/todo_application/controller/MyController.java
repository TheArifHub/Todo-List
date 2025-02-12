package com.todo.todo_application.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.todo.todo_application.dto.Task;
import com.todo.todo_application.service.TaskService;

@Controller
public class MyController {

	@Autowired
	TaskService service;

	@GetMapping
	public String loadhome(Model model) {
		List<Task> list = service.getAllTasks();
		model.addAttribute("tasks", list);
		return "home";
	}

	@PostMapping
	public String savetask(@RequestParam String title) {
		service.saveRecored(title);
		return "redirect:/";
	}

	@GetMapping("/{id}/delete")
	public String delete(@PathVariable int id) {
		service.delete(id);
		return "redirect:/";
	}

	@GetMapping("/{id}/completed")
	public String completed(@PathVariable int id) {
		service.completed(id);
		return "redirect:/";
	}
}
