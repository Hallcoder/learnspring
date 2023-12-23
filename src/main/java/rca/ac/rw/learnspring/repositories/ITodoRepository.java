package rca.ac.rw.learnspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rca.ac.rw.learnspring.models.Todo;

import java.util.UUID;

public interface ITodoRepository extends JpaRepository<Todo, UUID> {
}
