package chapter_06_oop_principles.work_session;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime startTime1 = LocalDateTime.of(2026, 4, 7, 9, 30);
        LocalDateTime endTime1 = LocalDateTime.of(2026, 4, 7, 11, 30);

        WorkSession session1 = new WorkSession(startTime1, endTime1, "Session 1", "1");

        System.out.println(session1.getDuration() + " minutes");

        LocalDateTime startTime2 = LocalDateTime.of(2026, 4, 7, 12, 30);
        LocalDateTime endTime2 = LocalDateTime.of(2026, 4, 7, 11, 30);

        WorkSession session2 = new WorkSession(startTime2, endTime2, "Session 2", "2");

        System.out.println(session2.getDuration() + " minutes");
    }
}