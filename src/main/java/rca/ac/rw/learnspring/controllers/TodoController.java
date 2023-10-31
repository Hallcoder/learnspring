package rca.ac.rw.learnspring.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    @GetMapping
    public ResponseEntity getTodos(){
        return ResponseEntity.ok("There you go!");
    }
}
