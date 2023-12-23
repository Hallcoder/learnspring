package rca.ac.rw.learnspring.exceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rca.ac.rw.learnspring.utils.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler{
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity exception(RuntimeException ex){
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(ex.getMessage(),ex.getCause(),HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler(value = TodoNotFoundException.class)
    public ResponseEntity exception(TodoNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Todo not found",ex.getCause(), HttpStatus.NOT_FOUND));
    }
}
