package linkedlist;


import java.util.LinkedList;

public class LinkedListTask2_TaskQueue {

    public static void main(String[] args) {
        linkedListTaskQueue();
    }

    public static void linkedListTaskQueue() {
        LinkedList<String> tasks = new LinkedList<>();
        tasks.add("Загрузка");
        tasks.add("Обработка");
        tasks.add("Отправка");
        while (!tasks.isEmpty()) {
            String task = tasks.poll();
            System.out.println("Обработка задачи: " + task);
        }
    }
}
