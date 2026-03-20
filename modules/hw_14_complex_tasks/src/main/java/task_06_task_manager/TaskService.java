package task_06_task_manager;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class TaskService<T> {
    private final Map<T, Task<T>> tasks = new ConcurrentHashMap<>();

    public void addTask(Task<T> task) throws DuplicateTaskException {
        Task<T> existingTask = tasks.putIfAbsent(task.getId(), task);

        if (existingTask != null) {
            throw new DuplicateTaskException(task.getId());
        }
    }

    public void removeTask(T id) {
        Task<T> removedTask = tasks.remove(id);
        if (removedTask == null) {
            throw new TaskNotFoundException(id);
        }
    }

    public Optional<Task<T>> findTaskById(T id) {
        return Optional.ofNullable(tasks.get(id));
    }

    public List<Task<T>> filterTasksByStatus(TaskStatus status) {
        return tasks.values().stream()
                .filter(tTask -> tTask.getStatus() == status).collect(Collectors.toList());
    }

    public List<Task<T>> filterTasksByPriority(Priority priority) {
        return tasks.values().stream()
                .filter(tTask -> tTask.getPriority() == priority).collect(Collectors.toList());
    }

    public List<Task<T>> filterTasksByStatusAndPriority(TaskStatus status, Priority priority) {
        return tasks.values().stream()
                .filter(tTask -> tTask.getStatus() == status)
                .filter(tTask -> tTask.getPriority() == priority)
                .collect(Collectors.toList());
    }

    public List<Task<T>> getTasksSortedByDate(boolean ascending) {
        Comparator<Task<T>> dateComparator = Comparator.comparing(Task::getCreatedAt);

        if (!ascending) {
            dateComparator = dateComparator.reversed();
        }

        return tasks.values().stream().sorted(dateComparator).collect(Collectors.toList());
    }

    public List<Task<T>> getTasksSortedByPriority(boolean descending) {
        Comparator<Task<T>> priorityComparator = Comparator.comparing(Task::getPriority);
        if (descending) {
            priorityComparator = priorityComparator.reversed();
        }

        return tasks.values().stream().sorted(priorityComparator).collect(Collectors.toList());
    }
}
