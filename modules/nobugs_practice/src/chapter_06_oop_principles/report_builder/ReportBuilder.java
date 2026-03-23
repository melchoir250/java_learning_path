package chapter_06_oop_principles.report_builder;

import java.util.ArrayList;
import java.util.List;

public class ReportBuilder {
    List<ReportPart> reportParts = new ArrayList<>();

    public void addParts(ReportPart part) {
        reportParts.add(part);
    }

    public void buildReport() {
        for (ReportPart report : reportParts) {
            report.render();
        }
    }
}