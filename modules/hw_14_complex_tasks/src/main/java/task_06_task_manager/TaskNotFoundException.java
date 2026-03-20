package task_06_task_manager;


public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Object id) {
        super("Задача с " + id + " не найдена");
    }
}
