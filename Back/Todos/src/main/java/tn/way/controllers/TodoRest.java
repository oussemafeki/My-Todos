package tn.way.controllers;

import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	 @GetMapping("/retrieve-all-Todos") 
	 @ResponseBody 
	 public List<Todo> getTodos() { 
		 List<Todo> list = TodoService.retrieveAllTodos(); 
		 return list; }
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
	 @GetMapping("/retrieve-Todo/{Todo-id}") 
	 @ResponseBody 
	 public Todo retrieveTodo(@PathVariable("Todo-id") int TodoId) { 
		 return TodoService.retrieveTodo(TodoId);  } 
}
