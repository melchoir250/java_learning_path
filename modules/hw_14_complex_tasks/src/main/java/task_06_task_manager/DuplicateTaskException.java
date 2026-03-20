package task_06_task_manager;


public class DuplicateTaskException extends RuntimeException {
    public DuplicateTaskException(Object id) {
        super("Задача " + id + " уже существует");
    }
}

