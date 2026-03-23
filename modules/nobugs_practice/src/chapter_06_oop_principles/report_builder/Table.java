package chapter_06_oop_principles.report_builder;

public class Table implements ReportPart {
    public final String title;

    public Table(String title) {
        this.title = title;
    }

    @Override
    public void render() {
        System.out.println(title);
    }
}