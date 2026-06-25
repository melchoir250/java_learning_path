public class WmvVideoAdapter implements VideoAdapter {

    @Override
    public String getFormat() {
        return "wmv";
   
    }

    @Override
    public String convertToMp4(String filePath) {
        String mp4Path = filePath.substring(0, filePath.lastIndexOf('.')) + ".mp4";
        System.out.println("Конвертация WMV в MP4: " + filePath + " -> " + mp4Path);
        return mp4Path;
    }
}
