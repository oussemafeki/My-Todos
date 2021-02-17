package tn.way.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.way.entities.Todo;
import tn.way.repositories.TodoRepository;

@Service
public class TodoService  implements ITodoService{
	@Autowired
	TodoRepository todoRepo ; 
	private static final Logger l = LogManager.getLogger(TodoService.class);

	@Override
	public List<Todo> retrieveAllTodos() {
		List<Todo> todos = (List<Todo>) todoRepo.findAll();
		for(Todo to : todos)
		{
			l.info("todo +++ : "+to);
		}
		return todos;
	}



	@Override
	public Todo updateTodo(Todo t) {
		l.info("Updating todo with ID: "+t.getId());
		return this.todoRepo.save(t);
	}

	@Override
	public Todo retrieveTodo(int id) {
		l.info("Retriving todo with ID: "+id);
		return this.todoRepo.findById(id).get();
	}

}
