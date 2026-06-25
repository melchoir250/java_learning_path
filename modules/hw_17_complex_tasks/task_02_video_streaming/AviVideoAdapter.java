public class AviVideoAdapter implements VideoAdapter {

    @Override
    public String getFormat() {
        return "avi";
    }

    @Override
    public String convertToMp4(String filePath) {
        String mp4Path = filePath.substring(0, filePath.lastIndexOf('.')) + ".mp4";
        System.out.println("Конвертация AVI в MP4: " + filePath + " -> " + mp4Path);
        return mp4Path;
    }
}
