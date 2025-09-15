package franco.ortiz.taskManager.DTO;
import franco.ortiz.taskManager.model.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDTOInput {
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no debe superar los 100 caracteres")
    private String name;
    @Size(max = 250, message = "La descripción no debe superar los 250 caracteres")
    private String description;
    @NotNull(message = "El estado es obligatorio")
    private Status status;
}
