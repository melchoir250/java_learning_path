package mock_interviews.task5;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PdfReport pdfReport1 = new PdfReport("pDf");
        PdfReport pdfReport2 = new PdfReport("PDf");

        HtmlReport htmlReport1 = new HtmlReport("HtmL");
        HtmlReport htmlReport2 = new HtmlReport("hTmL");

        ExcelReport excelReport1 = new ExcelReport("ExCel");
        ExcelReport excelReport2 = new ExcelReport("EXCel");

        ReportService reportService = new ReportService(List.of(
                pdfReport1, pdfReport2, htmlReport1, htmlReport2, excelReport1, excelReport2
        ));
        reportService.deliveryReport();
    }
}