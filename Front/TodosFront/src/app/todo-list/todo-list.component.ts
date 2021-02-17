import { Component, OnInit } from '@angular/core';
import { TodoService } from '../todo.service';
import { Todo} from '../todo';

import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {
  todos: Observable<Todo[]>;

  constructor(private todoService: TodoService ,
    private router: Router) { }

  ngOnInit(): void {
    this.todos=this.todoService.getTodosList();
  }
  TodoUpdate(id:number){
    this.router.navigate(['update', id]);
  }

}
