public class VideoStream {
    private final String videoId;
    private final String mp4Path;

    public VideoStream(String videoId, String mp4Path) {
        this.videoId = videoId;
        this.mp4Path = mp4Path;
    }

    public String getVideoId() {
        return videoId;
    }

    public String getMp4Path() {
        return mp4Path;
    }
}
