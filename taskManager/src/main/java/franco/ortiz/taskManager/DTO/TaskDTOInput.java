package franco.ortiz.taskManager.DTO;
import franco.ortiz.taskManager.model.Status;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDTOInput {
    private String name;
    private String description;
    private Status status;
}
