package rca.ac.rw.learnspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rca.ac.rw.learnspring.dtos.CreateTodoDTO;
import rca.ac.rw.learnspring.dtos.GetTodoDTO;
import rca.ac.rw.learnspring.exceptionHandlers.TodoNotFoundException;
import rca.ac.rw.learnspring.models.Todo;
import rca.ac.rw.learnspring.services.ITodoService;
import rca.ac.rw.learnspring.utils.ApiResponse;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    private final ITodoService todoService;

    @Autowired
    public TodoController(ITodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity getTodos() {
        return ResponseEntity.ok(this.todoService.getTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity getTodoById(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(this.todoService.getTodoById(UUID.fromString(id)).orElseThrow(() -> new TodoNotFoundException()), "Here you go!"));
    }

    @PostMapping("/create")
    public ResponseEntity createTodo(@RequestBody CreateTodoDTO todo) {
        Todo newTodo = Todo.builder()
                .title(todo.getTitle())
                .scheduledAt(todo.getScheduledAt())
                .status(todo.getStatus()).build();
        return ResponseEntity.ok(this.todoService.create(newTodo));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTodo(@RequestBody CreateTodoDTO todo, @PathVariable("id") String id) {
        Todo existingTodo = this.todoService.getTodoById(UUID.fromString(id)).orElseThrow(() -> new NoSuchElementException("Todo not found"));
        Todo updatedTodo = Todo.builder().title(todo.getTitle()).status(todo.getStatus()).scheduledAt(todo.getScheduledAt()).build();
        return ResponseEntity.ok(this.todoService.update(updatedTodo));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTodo(@PathVariable("id") UUID id) {
        Todo t = this.todoService.getTodoById(id).orElseThrow();
        this.todoService.delete(t);
        return ResponseEntity.ok("Deleted successfully!");
    }
}
