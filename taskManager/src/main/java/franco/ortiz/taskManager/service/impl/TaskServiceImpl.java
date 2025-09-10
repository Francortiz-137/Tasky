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
        return taskRepository.findByName(name).orElse(null);
    }

    @Override
    public List<TaskEntity> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public TaskEntity findById(long id) {
        //todo exception management
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public TaskEntity save(TaskEntity task) {
        return taskRepository.save(task);
    }

    @Override
    public void delete(Long id) {
     taskRepository.deleteById(id);
    }

    @Override
    public TaskEntity update(Long id, TaskEntity newtask) {
        newtask.setId(id);
        return taskRepository.save(newtask);
    }
}
