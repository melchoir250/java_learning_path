package mock_interviews.task5;

public class PdfReport extends ReportAbstract {
    public PdfReport(String nameReport) {
        super(nameReport);
    }

    @Override
    public String report() {
        return nameReport.toUpperCase() + " отчёт формируется в " + nameReport.toLowerCase() + "-файл";
    }
}