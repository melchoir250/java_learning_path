package task_02_video_streaming;

public interface VideoAdapter {
    String getFormat();

    String convertToMp4(String filePath);
}
