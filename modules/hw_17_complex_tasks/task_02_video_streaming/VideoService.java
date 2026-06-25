import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class VideoService {
    private final Map<String, VideoAdapter> adapters = new HashMap<>();
    private final Map<String, Video> videos = new HashMap<>();

    public VideoService(VideoAdapter... videoAdapters) {
        for (VideoAdapter adapter : videoAdapters) {
            adapters.put(adapter.getFormat(), adapter);
        }
}
    public Video uploadVideo(String videoPath) {
        String format = extractFormat(videoPath);
        VideoAdapter adapter = adapters.get(format);
        if (adapter == null) {
            throw new IllegalArgumentException("Формат не поддерживается: " + format);
        }
        String mp4Path = adapter.convertToMp4(videoPath);
        String id = UUID.randomUUID().toString();
        Video video = new Video(id, videoPath, mp4Path, format);
        videos.put(id, video);
        return video;
    }

    public VideoStream streamVideo(String videoId) {
        Video video = videos.get(videoId);
        if (video == null) {
            throw new IllegalArgumentException("Видео не найдено: " + videoId);
        }
        return new VideoStream(video.getId(), video.getMp4Path());
    }

    private String extractFormat(String videoPath) {
        int dotIndex = videoPath.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == videoPath.length() - 1) {
            throw new IllegalArgumentException("Не удалось определить формат: " + videoPath);
        }
        return videoPath.substring(dotIndex + 1).toLowerCase();
    }
}
