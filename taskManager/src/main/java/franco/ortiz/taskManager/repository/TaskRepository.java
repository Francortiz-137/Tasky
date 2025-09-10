package franco.ortiz.taskManager.repository;

import franco.ortiz.taskManager.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    Optional<TaskEntity> findByName(String name);
}
