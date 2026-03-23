package chapter_06_oop_principles.report_builder;

public class Header implements ReportPart {
    private final String title;

    public Header(String title) {
        this.title = title;
    }

    @Override
    public void render() {
        System.out.println(title);
    }
}
