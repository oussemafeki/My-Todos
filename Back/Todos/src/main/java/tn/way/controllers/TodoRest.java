package tn.way.controllers;

import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.way.entities.Todo;
import tn.way.services.ITodoService;

@RestController
public class TodoRest {
	@Autowired
	ITodoService TodoService ; 
	@CrossOrigin(origins = "http://localhost:4200")
	 @GetMapping("/retrieve-all-Todos") 
	 public List<Todo> getTodos() { 
		 List<Todo> list = TodoService.retrieveAllTodos(); 
		 return list; }
	@CrossOrigin(origins = "http://localhost:4200")
	 @PutMapping("/modify-Todo") 
	 @ResponseBody 
	 public void modifyTodo(@RequestBody Todo Todo) { 
		 if (Todo.getDateDebut().before(Todo.getDateDecheance()))
		 {
			 TodoService.updateTodo(Todo);  
		 }
		 else {
			 System.out.print("erreur date d'echeance !");
		 }
		  }
	@CrossOrigin(origins = "http://localhost:4200")
	 @GetMapping("/retrieve-Todo/{Todo-id}") 
	 public Todo retrieveTodo(@PathVariable("Todo-id") int TodoId) { 
		 return TodoService.retrieveTodo(TodoId);  } 
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/add-Todo") 
	 @ResponseBody 
	 public Todo addTodo(@RequestBody Todo t) { 
		t.setStatut(false);
		 Todo Todo = TodoService.addTodo(t); 
		 return Todo ; }
}
