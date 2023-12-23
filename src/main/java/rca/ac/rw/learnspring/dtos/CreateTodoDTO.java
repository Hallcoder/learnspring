package rca.ac.rw.learnspring.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import rca.ac.rw.learnspring.Enumerations.EStatus;

import java.util.Date;
import java.util.UUID;

@Data
public class CreateTodoDTO {
    private UUID id;

    private String title;
    private EStatus status;

    private Date scheduledAt;

}
