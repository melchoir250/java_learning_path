public class Main {
    public static void main(String[] args) {
        VideoService videoService = new VideoService(
                new AviVideoAdapter(),
                new MovVideoAdapter(),
                new WmvVideoAdapter()
        );

        String videoPath = "path/to/example.avi";
        Video video = videoService.uploadVideo(videoPath);

        VideoStream stream = videoService.streamVideo(video.getId());

        System.out.println("Streaming video in MP4 format, Video ID: " + video.getId());
        System.out.println("MP4 path: " + stream.getMp4Path());
    }
}
