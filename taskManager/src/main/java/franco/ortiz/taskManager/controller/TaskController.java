package franco.ortiz.taskManager.controller;

import franco.ortiz.taskManager.service.ITaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final ITaskService taskService;

    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getTask(){
        return ResponseEntity.ok( taskService.findAll());
    }
}
