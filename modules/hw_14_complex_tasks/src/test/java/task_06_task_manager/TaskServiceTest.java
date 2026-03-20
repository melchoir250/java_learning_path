package task_06_task_manager;

import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    private TaskService<String> taskService;
    private Task<String> task1;
    private Task<String> task2;
    private Task<String> task3;

    @BeforeEach
    void setUp() {
        taskService = new TaskService<>();

        task1 = new Task<>("TASK-1", "Починить баг", TaskStatus.TODO, Priority.HIGH);
        pauseForUniqueTimestamps();
        task2 = new Task<>("TASK-2", "Написать тесты", TaskStatus.IN_PROGRESS, Priority.CRITICAL);
        pauseForUniqueTimestamps();
        task3 = new Task<>("TASK-3", "Выпить кофе", TaskStatus.DONE, Priority.LOW);
    }

    private void pauseForUniqueTimestamps() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            fail("Тест был прерван во время ожидания уникальных timestamp");
        }
    }

    @Test
    void shouldAddTaskSuccessfully() {
        taskService.addTask(task1);

        Optional<Task<String>> found = taskService.findTaskById("TASK-1");
        assertTrue(found.isPresent());
        assertEquals("Починить баг", found.get().getDescription());
    }

    @Test
    void shouldThrowExceptionWhenAddingDuplicateTask() {
        taskService.addTask(task1);

        Task<String> duplicateTask = new Task<>("TASK-1", "Другое описание", TaskStatus.TODO, Priority.LOW);

        assertThrows(DuplicateTaskException.class, () -> taskService.addTask(duplicateTask));
    }

    @Test
    void shouldRemoveTaskSuccessfully() {
        taskService.addTask(task1);
        taskService.removeTask("TASK-1");

        Optional<Task<String>> found = taskService.findTaskById("TASK-1");
        assertTrue(found.isEmpty());
    }

    @Test
    void shouldThrowExceptionWhenRemovingNonExistentTask() {
        assertThrows(TaskNotFoundException.class, () -> taskService.removeTask("TASK-999"));
    }

    @Test
    void shouldFilterTasksByStatusAndPriority() {
        taskService.addTask(task1);
        taskService.addTask(task2);
        taskService.addTask(task3);

        Task<String> task4 = new Task<>("TASK-4", "Еще одна важная задача", TaskStatus.TODO, Priority.CRITICAL);
        taskService.addTask(task4);

        List<Task<String>> todoTasks = taskService.filterTasksByStatus(TaskStatus.TODO);
        assertEquals(2, todoTasks.size());

        List<Task<String>> criticalTodoTasks = taskService.filterTasksByStatusAndPriority(TaskStatus.TODO, Priority.CRITICAL);
        assertEquals(1, criticalTodoTasks.size());
        assertEquals("TASK-4", criticalTodoTasks.get(0).getId());
    }

    @Test
    void shouldSortTasksByPriorityDescending() {
        taskService.addTask(task3);
        taskService.addTask(task2); // CRITICAL
        taskService.addTask(task1); // HIGH

        List<Task<String>> sortedTasks = taskService.getTasksSortedByPriority(true);

        assertEquals("TASK-2", sortedTasks.get(0).getId()); // CRITICAL
        assertEquals("TASK-1", sortedTasks.get(1).getId()); // HIGH
        assertEquals("TASK-3", sortedTasks.get(2).getId()); // LOW
    }

    @Test
    void shouldSortTasksByDateAscending() {
        taskService.addTask(task3);
        taskService.addTask(task1);
        taskService.addTask(task2);

        List<Task<String>> sortedTasks = taskService.getTasksSortedByDate(true);

        assertEquals("TASK-1", sortedTasks.get(0).getId());
        assertEquals("TASK-2", sortedTasks.get(1).getId());
        assertEquals("TASK-3", sortedTasks.get(2).getId());
    }

    @Test
    void shouldHandleConcurrentAdditionsSafely() throws InterruptedException {

        TaskService<Integer> concurrentService = new TaskService<>();

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; i++) {
            final int taskId = i;
            executor.submit(() -> {
                Task<Integer> task = new Task<>(taskId, "Task " + taskId, TaskStatus.TODO, Priority.MEDIUM);
                concurrentService.addTask(task);
            });
        }

        executor.shutdown();

        boolean finished = executor.awaitTermination(1, TimeUnit.MINUTES);
        assertTrue(finished, "Потоки не завершили работу за отведенное время");

        List<Task<Integer>> allTasks = concurrentService.filterTasksByStatus(TaskStatus.TODO);
        assertEquals(1000, allTasks.size());
    }
}
