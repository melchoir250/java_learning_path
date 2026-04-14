package mock_interviews.task5;

import java.util.List;

public class ReportService {
    public List<Report> reports;

    public ReportService(List<Report> reports) {
        this.reports = reports;
    }

    public void deliveryReport() {
        for (Report item : reports) {
            System.out.println(item.report());
        }
    }
}