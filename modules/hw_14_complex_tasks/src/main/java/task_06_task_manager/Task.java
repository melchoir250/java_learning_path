package task_06_task_manager;


import java.time.LocalDateTime;
import java.util.Objects;

public class Task<T> {
    private final T id;
    private final String description;
    private final TaskStatus status;
    private final Priority priority;
    private final LocalDateTime createdAt;

    public Task(T id, String description, TaskStatus status, Priority priority) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.createdAt = LocalDateTime.now();
    }

    public T getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public Priority getPriority() {
        return priority;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Task<T> task = (Task<T>) o;
        return id.equals(task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}