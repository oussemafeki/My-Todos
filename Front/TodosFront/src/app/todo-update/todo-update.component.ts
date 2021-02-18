import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Todo } from '../todo';
import { TodoService } from '../todo.service';

@Component({
  selector: 'app-todo-update',
  templateUrl: './todo-update.component.html',
  styleUrls: ['./todo-update.component.css']
})
export class TodoUpdateComponent implements OnInit {
  id: number;
  todo: Todo;
  minDate = new Date();
  submitted = false;
  statut: string[];

  constructor(private route: ActivatedRoute,private router: Router,
    private todoService: TodoService) { }

  ngOnInit(): void {
    this.statut=["Ouverte","Fermée"];
    this.todo = new Todo();
    this.id = this.route.snapshot.params['id'];
    this.todoService.getTodo(this.id)
      .subscribe(data => {
        console.log(data)
        this.todo = data;
      }, error => console.log(error));
  }
  updateTodo() {
    this.todoService.updateTodo( this.todo)
      .subscribe(data => {console.log(data);
        this.submitted = true;}, error => console.log(error));
    this.todo = new Todo();
    //this.gotoList();
  }

  onSubmit() {
    this.updateTodo();    
  }

  gotoList() {
    this.router.navigate(['/todos']);
  }

}
