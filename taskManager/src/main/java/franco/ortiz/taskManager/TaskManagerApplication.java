package franco.ortiz.taskManager;

import franco.ortiz.taskManager.model.Status;
import franco.ortiz.taskManager.model.TaskEntity;
import franco.ortiz.taskManager.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class TaskManagerApplication  implements CommandLineRunner {

    private final TaskRepository taskRepository;

    public TaskManagerApplication(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        TaskEntity task = new TaskEntity();
        task.setName("Task1");
        task.setDescription("Task1");
        task.setStatus(Status.PENDING);
        task.setCreationDate(LocalDateTime.now());

        //taskRepository.save(task);
    }
}
