package task_02_video_streaming;

public class MovVideoAdapter implements VideoAdapter {

    @Override
    public String getFormat() {
        return "mov";
    }

    @Override
    public String convertToMp4(String filePath) {
        String mp4Path = filePath.substring(0, filePath.lastIndexOf('.')) + ".mp4";
        System.out.println("Конвертация MOV в MP4: " + filePath + " -> " + mp4Path);
        return mp4Path;
    }
}
