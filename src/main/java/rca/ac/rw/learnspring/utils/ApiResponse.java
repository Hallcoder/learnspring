package rca.ac.rw.learnspring.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApiResponse<T> {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    private String message = "";
    private HttpStatus status;
    private Boolean success;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object error = null;
    private final String timestamp = LocalDateTime.now().toString();

    public ApiResponse() {
    }
    public ApiResponse(boolean success, Object data) {
        this.success = success;
        this.message = message;
    }

    public static ApiResponse success(Object data) {
        return new ApiResponse(true, data);
    }
    public ApiResponse(String message, Object error, HttpStatus status) {
        this.message = message;
        this.error = error;
        this.status = status;
    }
    public ApiResponse(T data, String message, Object error, HttpStatus status) {
        this.message = message;
        this.error = error;
        this.status = status;
    }

    public ApiResponse(T data) {
        this.data = data;
    }




    public ApiResponse(String message) {
        this.message = message;
    }

    public ApiResponse(T data, HttpStatus status) {
        this.data = data;
        this.status = status;
    }

    public ApiResponse(T data, String message) {
        this.data = data;
        this.message = message;
    }
    public ApiResponse(T data, String message, HttpStatus status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public ResponseEntity<ApiResponse<T>> toResponseEntity() {
        assert this.status != null;
        return ResponseEntity.status(this.status).body(this);
    }

}


