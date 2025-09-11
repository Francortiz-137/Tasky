package franco.ortiz.taskManager.DTO;

import franco.ortiz.taskManager.model.TaskEntity;

import java.time.LocalDateTime;

public class TaskMapper {

    public static TaskEntity toEntity(TaskDTOInput request) {
        return TaskEntity.builder()
                .name(request.getName())
                .description(request.getDescription())
                .status(request.getStatus())
                .creationDate(LocalDateTime.now())
                .build();
    }

    public static TaskDTOOutput toDTO(TaskEntity entity) {
        return TaskDTOOutput.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .creationDate(entity.getCreationDate())
                .build();
    }
}

