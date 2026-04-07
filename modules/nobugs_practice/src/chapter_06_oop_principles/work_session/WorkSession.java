package chapter_06_oop_principles.work_session;

import java.time.Duration;
import java.time.LocalDateTime;

public class WorkSession {
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final String description;
    private final String sessionId;

    public WorkSession(LocalDateTime startTime, LocalDateTime endTime, String description, String sessionId) {
        if (startTime.isBefore(endTime)) {
            this.startTime = startTime;
            this.endTime = endTime;
        } else {
            throw new IllegalArgumentException("EndTime не может быть раньше StartTime");
        }
        this.description = description;
        this.sessionId = sessionId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getDescription() {
        return description;
    }

    public String getSessionId() {
        return sessionId;
    }

    public long getDuration() {
        return Duration.between(getStartTime(), getEndTime()).toMinutes();
    }
}