import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Todo } from '../todo';
import { TodoService } from '../todo.service';

@Component({
  selector: 'app-todo-create',
  templateUrl: './todo-create.component.html',
  styleUrls: ['./todo-create.component.css']
})
export class TodoCreateComponent implements OnInit {
  todo: Todo = new Todo();
  submitted = false;
  minDate = new Date();



  constructor(private todoService: TodoService,
    private router: Router) { }

  ngOnInit(): void {
  }
  
  save() {
    this.todoService.createTodo(this.todo)
      .subscribe(data => {console.log(data) ;
        this.submitted = true;} 
      , error => console.log(error));
    this.todo = new Todo();
  }
  onSubmit() {
    
    console.log(this.todo)
    this.save();    
  }
  gotoList() {
    this.router.navigate(['/todos']);
  }
  

}
