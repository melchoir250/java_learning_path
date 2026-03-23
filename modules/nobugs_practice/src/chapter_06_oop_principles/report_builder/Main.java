package chapter_06_oop_principles.report_builder;

public class Main {
    public static void main(String[] args) {
        ReportBuilder reportBuilder = new ReportBuilder();
        Header header = new Header("Финансовый отчет за 2025 год");
        Table table1 = new Table("Доходы: 1 500 000 руб");
        Table table2 = new Table("Расходы: 800 000 руб");
        Footer footer = new Footer("Итоговая прибыль: 700 000 руб");
        reportBuilder.addParts(header);
        reportBuilder.addParts(table1);
        reportBuilder.addParts(table2);
        reportBuilder.addParts(footer);
        reportBuilder.buildReport();
    }
}