package franco.ortiz.taskManager.service;

import franco.ortiz.taskManager.DTO.TaskDTOInput;
import franco.ortiz.taskManager.DTO.TaskDTOOutput;
import franco.ortiz.taskManager.model.TaskEntity;

import java.util.List;

public interface ITaskService {
    TaskDTOOutput findByName(String name);
    List<TaskDTOOutput> findAll();
    TaskDTOOutput findById(long id);
    TaskDTOOutput save(TaskDTOInput task);
    void delete(Long id);
    TaskDTOOutput update(Long id, TaskDTOInput newtask);
}
