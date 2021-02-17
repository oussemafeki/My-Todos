import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private baseUrl = 'http://localhost:8081';

  constructor(private http: HttpClient) { }

  getTodosList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/retrieve-all-Todos`);
  }
  getTodo(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/retrieve-Todo/${id}`);
  }
  updateTodo(Todo: Object): Observable<Object> {
    return this.http.put(`${this.baseUrl}/modify-Todo`, Todo);
  }
}
