package mock_interviews.task5;

public class ExcelReport extends ReportAbstract {
    public ExcelReport(String nameReport) {
        super(nameReport);
    }

    @Override
    public String report() {
        return nameReport.toUpperCase() + " отчёт формируется в таблицу";
    }
}