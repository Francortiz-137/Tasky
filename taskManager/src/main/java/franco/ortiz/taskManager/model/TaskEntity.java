package franco.ortiz.taskManager.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;
    @Enumerated(EnumType.STRING)
    Status status;
    @Column(updatable = false, nullable = false, name = "CREATION_DATE")
    LocalDateTime creationDate;
}
