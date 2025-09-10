package franco.ortiz.taskManager.service;

import franco.ortiz.taskManager.model.TaskEntity;

import java.util.List;

public interface ITaskService {
    TaskEntity findByName(String name);
    List<TaskEntity> findAll();
    TaskEntity findById(long id);
    TaskEntity save(TaskEntity task);
    void delete(Long id);
    TaskEntity update(Long id, TaskEntity newtask);
}
