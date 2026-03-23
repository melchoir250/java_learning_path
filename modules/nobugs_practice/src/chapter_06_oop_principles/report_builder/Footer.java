package chapter_06_oop_principles.report_builder;

public class Footer implements ReportPart {
    public final String title;

    public Footer(String title) {
        this.title = title;
    }

    @Override
    public void render() {
        System.out.println(title);
    }
}