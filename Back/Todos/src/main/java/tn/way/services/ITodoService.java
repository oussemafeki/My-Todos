package tn.way.services;

import java.util.List;

import tn.way.entities.Todo;


public interface ITodoService {
	List<Todo> retrieveAllTodos(); 
	 Todo updateTodo(Todo t); 
	 Todo retrieveTodo(int id);
}
