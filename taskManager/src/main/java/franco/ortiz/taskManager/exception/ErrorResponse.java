package franco.ortiz.taskManager.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private LocalDateTime creationDate;
    private int status;
    private String message;
    private String error;
    private String path;
}
