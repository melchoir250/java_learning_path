package task_museum;

public class Main {
    public static void main(String[] args) {
        Museum museum = new Museum();

        Exhibit manuscript = new Manuscript();
        museum.setExhibit(manuscript);
        System.out.print("Манускрипт - ");
        museum.showExibit();

        Exhibit sculpture = new Sculpture();
        museum.setExhibit(sculpture);
        System.out.print("Манускрипт - ");
        museum.showExibit();

    }
}
