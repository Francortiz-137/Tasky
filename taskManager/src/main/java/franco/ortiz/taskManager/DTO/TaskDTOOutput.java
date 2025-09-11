package franco.ortiz.taskManager.DTO;

import franco.ortiz.taskManager.model.Status;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDTOOutput {
    private Long id;
    private String name;
    private String description;
    private Status status;
    private LocalDateTime creationDate;
}
