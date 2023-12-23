package rca.ac.rw.learnspring.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rca.ac.rw.learnspring.models.Todo;
import rca.ac.rw.learnspring.repositories.ITodoRepository;
import rca.ac.rw.learnspring.services.ITodoService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TodoServiceImpl implements ITodoService {
    private final ITodoRepository todoRepository;
    @Autowired
    public TodoServiceImpl(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo create(Todo todo) {
        Todo newTodo = this.todoRepository.save(todo);
        return newTodo;
    }

    @Override
    public Todo update(Todo todo) {
        return null;
    }

    @Override
    public void delete(Todo todo) {

    }

    @Override
    public List<Todo> getTodos() {
        return this.todoRepository.findAll();
    }

    @Override
    public Optional<Todo> getTodoById(UUID id) {
        return this.todoRepository.findById(id);
    }
}
