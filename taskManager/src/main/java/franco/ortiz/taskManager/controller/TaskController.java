package franco.ortiz.taskManager.controller;

import franco.ortiz.taskManager.DTO.TaskDTOInput;
import franco.ortiz.taskManager.DTO.TaskDTOOutput;
import franco.ortiz.taskManager.exception.ErrorResponse;
import franco.ortiz.taskManager.model.TaskEntity;
import franco.ortiz.taskManager.service.ITaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final ITaskService taskService;

    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Obtener todas las tareas", description = "Devuelve una lista con todas las tareas registradas")
    @ApiResponse(responseCode = "200", description = "Lista obtenida exitosamente")
    @GetMapping("")
    public ResponseEntity<Object> getTask(){
        return ResponseEntity.ok( taskService.findAll());
    }

    @Operation(summary = "Obtener tarea por ID", description = "Busca una tarea según su identificador único")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Tarea encontrada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TaskDTOOutput.class))),
            @ApiResponse(responseCode = "404", description = "Tarea no encontrada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/{id}")
    public TaskDTOOutput getTaskById(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @Operation(summary = "Crear una nueva tarea", description = "Registra una nueva tarea en el sistema")
    @ApiResponse(responseCode = "201", description = "Tarea creada exitosamente")
    @PostMapping
    public TaskDTOOutput createTask(@RequestBody TaskDTOInput task) {
        return taskService.save(task);
    }

    @Operation(summary = "Actualizar una tarea", description = "Permite actualizar los datos de una tarea existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Tarea actualizada"),
            @ApiResponse(responseCode = "404", description = "Tarea no encontrada")
    })
    @PutMapping("/{id}")
    public TaskDTOOutput updateTask(@PathVariable Long id, @RequestBody TaskDTOInput task) {
        return taskService.update(id, task);
    }

    @Operation(summary = "Eliminar una tarea", description = "Elimina una tarea existente por su ID")
    @ApiResponse(responseCode = "204", description = "Tarea eliminada")
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.delete(id);
    }
}
