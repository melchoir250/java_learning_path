package mock_interviews.task5;

public abstract class ReportAbstract implements Report {
    protected final String nameReport;

    public ReportAbstract(String nameReport) {
        this.nameReport = nameReport;
    }
}