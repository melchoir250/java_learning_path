package task_museum;

public class Museum {
    private Exhibit exhibit;

    public void setExhibit(Exhibit exhibit) {
        this.exhibit = exhibit;
    }

    public void showExibit() {
        System.out.println(exhibit.describe());
        exhibit.preserve();
    }
}
