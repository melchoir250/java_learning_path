package chapter_02_classes_objects;

public class Camera {
    String model;

    Camera(String someModel) {
        this.model = someModel;
    }

    void takePhoto() {
        System.out.println("Фото сделано на " + this.model);
    }

    public static void main(String[] args) {
        Camera sony = new Camera("Sony");
        sony.takePhoto();
    }
}
