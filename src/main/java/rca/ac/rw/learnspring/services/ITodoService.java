package rca.ac.rw.learnspring.services;

import rca.ac.rw.learnspring.dtos.CreateTodoDTO;
import rca.ac.rw.learnspring.models.Todo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ITodoService {
  Todo create(Todo todo);
  Todo update(Todo todo);

  void delete(Todo todo);

  List<Todo> getTodos();

  Optional<Todo> getTodoById(UUID id);
}
