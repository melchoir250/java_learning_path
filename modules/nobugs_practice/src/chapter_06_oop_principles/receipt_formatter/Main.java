package chapter_06_oop_principles.receipt_formatter;

public class Main {
    public static void main(String[] args) {
        ReceiptItem bread = new ReceiptItem("Хлеб", 50.00, 2);
        ReceiptItem milk = new ReceiptItem("Молоко", 80.00, 1);
        ReceiptItem cheese = new ReceiptItem("Сыр", 220.00, 1);

        double tax = 10.0;
        double discount = 0.0;

        PlainTextReceipt plainTextReceipt = new PlainTextReceipt(
                "Пятёрочка",
                "Санкт-Петербург, Невский пр., 10",
                java.time.LocalDateTime.now(),
                new java.util.ArrayList<>(),
                tax,
                discount
        );
        plainTextReceipt.addItem(bread);
        plainTextReceipt.addItem(milk);
        plainTextReceipt.addItem(cheese);

        HtmlReceipt htmlReceipt = new HtmlReceipt(
                "Пятёрочка",
                "Санкт-Петербург, Невский пр., 10",
                java.time.LocalDateTime.now(),
                new java.util.ArrayList<>(),
                tax,
                discount
        );
        htmlReceipt.addItem(bread);
        htmlReceipt.addItem(milk);
        htmlReceipt.addItem(cheese);

        JsonReceipt jsonReceipt = new JsonReceipt(
                "Пятёрочка",
                "Санкт-Петербург, Невский пр., 10",
                java.time.LocalDateTime.now(),
                new java.util.ArrayList<>(),
                tax,
                discount
        );
        jsonReceipt.addItem(bread);
        jsonReceipt.addItem(milk);
        jsonReceipt.addItem(cheese);

        System.out.println("===== PLAIN TEXT RECEIPT =====");
        System.out.println(plainTextReceipt.format());
        System.out.println();

        System.out.println("===== HTML RECEIPT =====");
        System.out.println(htmlReceipt.format());
        System.out.println();

        System.out.println("===== JSON RECEIPT =====");
        System.out.println(jsonReceipt.format());
    }
}