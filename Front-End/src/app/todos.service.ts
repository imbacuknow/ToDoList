import { environment } from './../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable  } from 'rxjs';
import { Todo } from './Todo';

@Injectable({
  providedIn: 'root'
})
export class TodosService {

  private apiServerUrl = environment.apiBaseUrl;

  private httpOption = {
    headers: new HttpHeaders({
      'content-type': 'application/json;charset=UTF-8'
    })
  };

  constructor(private http: HttpClient) { }

  getTodosAll(): Observable<Todo[]>{
    return this.http.get<Todo[]>(`${this.apiServerUrl}/todo/retrieveAllTodo`);
  }
  
  saveNewTodo(todo): Promise<Todo> {
    let body = { title: todo };
    return new Promise((success, error) => {
      this.http.post<Todo>(`${this.apiServerUrl}/todo/createNewTodo`, body).subscribe(res => {
        console.log("saveTodo success");
        console.log(res);
        success(res);
      }, err => {
        console.log(err);
        error(err);
      });
    })
  }

  updateTodoIsComplete(id: number): Promise<Todo> {
    return new Promise((success, error) => {
      this.http.put<Todo>(`${this.apiServerUrl}/todo/updateTodoStatus/${id}`, {}).subscribe(res => {
        console.log("todoIsCompleted");
        // console.log(res);
        success(res);
      }, err => {
        console.log(err);
        error(err);
      });
    })
  }

  deleteTodo(id: number): void {
    console.log(id);
    this.http.delete(`${this.apiServerUrl}/todo/delete/${id}`).subscribe(res => {
        console.log(res);
      }, err => {
        console.log(err);
      });
  }

  deleteAllTodo(): void {
    this.http.delete(`${this.apiServerUrl}/todo/deleteAll`).subscribe(res => {
        console.log(res);
      }, err => {
        console.log(err);
      });
  }
}
