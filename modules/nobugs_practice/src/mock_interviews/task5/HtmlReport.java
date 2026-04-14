package mock_interviews.task5;

public class HtmlReport extends ReportAbstract {
    public HtmlReport(String nameReport) {
        super(nameReport);
    }

    @Override
    public String report() {
        return nameReport.toUpperCase() + " отчёт формируется как веб-страница";
    }
}