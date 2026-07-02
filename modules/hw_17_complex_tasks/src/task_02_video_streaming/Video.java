package task_02_video_streaming;

public class Video {
    private final String id;
    private String originalPath;
    private String mp4Path;
    private String format;

    public Video(String id, String originalPath, String mp4Path, String format) {
        this.id = id;
        this.originalPath = originalPath;
        this.mp4Path = mp4Path;
        this.format = format;
    }

    public String getId() {
        return id;
    }

    public String getOriginalPath() {
        return originalPath;
    }

    public String getMp4Path() {
        return mp4Path;
    }

    public String getFormat() {
        return format;
    }
}
