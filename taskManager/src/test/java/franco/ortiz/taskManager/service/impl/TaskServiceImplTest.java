package franco.ortiz.taskManager.service.impl;

import franco.ortiz.taskManager.model.TaskEntity;
import franco.ortiz.taskManager.repository.TaskRepository;
import franco.ortiz.taskManager.service.ITaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskServiceImpl;

    public TaskServiceImplTest() {
    }

    @BeforeEach
    void setUp() {

    }

    @Test
    void findByName() {
        //Arrange
        TaskEntity task  = new TaskEntity();
        task.setId(1L);
        task.setName("Task1");
        task.setDescription("Task1");

        when(taskRepository.findByName("Task1")).thenReturn(Optional.of(task));
        //Act
        TaskEntity result = taskServiceImpl.findByName("Task1");
        //Assert
        assertNotNull(result);
        assertEquals("Task1", result.getName());

        verify(taskRepository, times(1)).findByName("Task1");

    }

    @Test
    void findAll() {
        TaskEntity task  = new TaskEntity();
        task.setId(1L);
        task.setName("Task1");
        task.setDescription("Task1");

        TaskEntity task2 = new TaskEntity();
        task2.setId(2L);
        task2.setName("Task2");
        task2.setDescription("Task2");
        TaskEntity task3 = new TaskEntity();
        task3.setId(3L);
        task3.setName("Task3");
        task3.setDescription("Task3");

        when(taskRepository.findAll()).thenReturn(List.of(task));
        List<TaskEntity> result = taskServiceImpl.findAll();
        assertNotNull(result);
        assertEquals(3, result.size());
        verify(taskRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        //Arrange
        TaskEntity task  = new TaskEntity();
        task.setId(1L);
        task.setName("Task1");
        task.setDescription("Task1");

        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        //Act
        TaskEntity result = taskServiceImpl.findById(1L);

        //Assert
        assertNotNull(result);
        assertEquals("Task1", result.getName());
        verify(taskRepository, times(1)).findById(1L);
    }

    @Test
    void save() {
        TaskEntity task = new TaskEntity();
        task.setId(1L);
        task.setName("Task1");
        task.setDescription("Task1");

        when(taskRepository.save(task)).thenReturn(task);
        TaskEntity result = taskServiceImpl.save(task);
        assertNotNull(result);
        assertEquals("Task1", result.getName());
        verify(taskRepository, times(1)).save(task);

    }

    @Test
    void delete() {
        TaskEntity task = new TaskEntity();
        task.setId(1L);
        task.setName("Task1");
        task.setDescription("Task1");
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        taskServiceImpl.delete(1L);
        verify(taskRepository, times(1)).delete(task);
    }

    @Test
    void update() {

        TaskEntity task = new TaskEntity();
        task.setId(1L);
        task.setName("Task1");
        task.setDescription("Task1");
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
        TaskEntity result = taskServiceImpl.update(1L, task);
        assertNotNull(result);
        assertEquals("Task1", result.getName());
        verify(taskRepository, times(1)).findById(1L);
    }
}