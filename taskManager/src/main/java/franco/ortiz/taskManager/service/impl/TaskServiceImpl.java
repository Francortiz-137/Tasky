package franco.ortiz.taskManager.service.impl;

import franco.ortiz.taskManager.DTO.TaskDTOInput;
import franco.ortiz.taskManager.DTO.TaskDTOOutput;
import franco.ortiz.taskManager.DTO.TaskMapper;
import franco.ortiz.taskManager.exception.ResourceNotFoundException;
import franco.ortiz.taskManager.model.TaskEntity;
import franco.ortiz.taskManager.repository.TaskRepository;
import franco.ortiz.taskManager.service.ITaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements ITaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskDTOOutput findByName(String name) {
        return TaskMapper.toDTO(taskRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("La tarea con nombre: " + name + " no existe")));
    }

    @Override
    public List<TaskDTOOutput> findAll() {
        return taskRepository.findAll().stream().map(TaskMapper::toDTO).toList();
    }

    @Override
    public TaskDTOOutput findById(long id) {
        return TaskMapper.toDTO(taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("La tarea con id: " + id + " no existe")));
    }

    @Override
    public TaskDTOOutput save(TaskDTOInput task) {
        TaskEntity taskEntity = TaskMapper.toEntity(task);
        return TaskMapper.toDTO(taskRepository.save(taskEntity));
    }

    @Override
    public void delete(Long id) {
     taskRepository.deleteById(id);
    }

    @Override
    public TaskDTOOutput update(Long id, TaskDTOInput newtask) {
        TaskEntity taskEntity = TaskMapper.toEntity(newtask);
        taskEntity.setId(id);
        return TaskMapper.toDTO(taskRepository.save(taskEntity));
    }
}
