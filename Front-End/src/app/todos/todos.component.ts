import { TodosService } from './../todos.service';
import { Component, OnInit } from '@angular/core';
import { faPen, faPlus } from '@fortawesome/free-solid-svg-icons';
import { faPenSquare } from '@fortawesome/free-solid-svg-icons';
import { faCheckSquare, faTrashAlt } from '@fortawesome/free-solid-svg-icons';
import { Todo } from '../Todo';
import { HttpErrorResponse } from '@angular/common/http';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-todos',
  templateUrl: './todos.component.html',
  styleUrls: ['./todos.component.scss']
})
export class TodosComponent implements OnInit {
  // icons
  faPlus = faPlus;
  faEdit = faPenSquare;
  faCheckSquare = faCheckSquare;
  faTashAlt = faTrashAlt;

  editableContent = false;

  completeBot = false;

  todos: Todo[] = [];

  todosComplete: Todo[] = [];

  // validate zone
  inputForm: FormGroup = new FormGroup({
    title: new FormControl('', [Validators.required, Validators.maxLength(120)])
  });

  constructor(private todoService: TodosService) { }

  ngOnInit(): void {
    this.getTodos();
  }

  showTodoCompleted() {
    this.completeBot = !this.completeBot;
  }

  removeTodoAll() {
    console.log("removeTodoAll");
    this.todoService.deleteAllTodo();
    this.todosComplete = [];
  }

  getTodos(): void {
    this.todoService.getTodosAll().subscribe(
      (res) => {
        this.todos = res.filter(e => e.isComplete==false);
        this.todosComplete = res.filter(e => e.isComplete==true);
        // console.log("Todos: ", res);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  addTodo() {
    this.todoService.saveNewTodo(this.inputForm.controls.title.value).then(todoResponse => {
      this.todos.push(todoResponse);
      this.inputForm.controls.title.reset();
    });
  }

  editTodoStatus(id: number, index: number) {
    this.todoService.updateTodoIsComplete(id).then(res => {
      console.log(res);
      this.todosComplete.push(res);
      this.todos.splice(index, 1);
    })
  }

  deleteTodoComplete(id: number, index: number) {
    this.todoService.deleteTodo(id);
    this.todosComplete.splice(index, 1);
  }

  deleteTodo(id: number, index: number) {
    this.todoService.deleteTodo(id);
    this.todos.splice(index, 1);
  }
}