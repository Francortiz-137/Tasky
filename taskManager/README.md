# 📝 Task Manager Backend

Backend de un **gestor de tareas** desarrollado con **Spring Boot**, que expone una API REST para crear, leer, actualizar y eliminar tareas.  
Es el componente de servidor de un proyecto **fullstack** (con frontend en HTML/JS).

---

## 🚀 Tecnologías utilizadas

- Java 17+
- Spring Boot 3
- Spring Web
- Spring Data JPA
- H2 Database (en memoria, para desarrollo)
- Maven
- JUnit 5

---

## 📂 Estructura del proyecto

src/main/java/com/example/taskmanager
- controller → Controladores REST
- service → Lógica de negocio
- repository → Repositorios JPA
- model → Entidades
- TaskManagerApplication.java


---

## 📌 Endpoints principales

| Método | Endpoint       | Descripción                     |
|--------|----------------|---------------------------------|
| GET    | `/tasks`       | Listar todas las tareas         |
| GET    | `/tasks/{id}`  | Obtener una tarea por ID        |
| POST   | `/tasks`       | Crear una nueva tarea           |
| PUT    | `/tasks/{id}`  | Actualizar una tarea existente  |
| DELETE | `/tasks/{id}`  | Eliminar una tarea              |

Ejemplo de JSON para **crear tarea**:

```json
{
  "title": "Aprender Spring Boot",
  "description": "Completar tutorial y probar API",
  "completed": false
}
```

▶️ Cómo ejecutar el proyecto

Clonar el repositorio:
```
git clone https://github.com/tuusuario/task-manager-backend.git
cd task-manager-backend
```

Compilar y ejecutar:
```
./mvnw spring-boot:run
```

API disponible en:
```
http://localhost:8080/tasks
```
🧪 Tests

Ejecutar pruebas con:
```
./mvnw test
```