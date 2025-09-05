package franco.ortiz.taskManager.service.impl;

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
    public TaskEntity findByName(String name) {
        return taskRepository.findByName(name);
    }

    @Override
    public List<TaskEntity> findAll() {
        return taskRepository.findAll();
    }
}
