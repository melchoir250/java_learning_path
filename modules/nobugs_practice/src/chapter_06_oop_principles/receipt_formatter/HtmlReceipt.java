package chapter_06_oop_principles.receipt_formatter;

import java.time.LocalDateTime;
import java.util.List;

public class HtmlReceipt extends Receipt {

    public HtmlReceipt(String storeName, String storeAddress,
                       LocalDateTime dateTime, List<ReceiptItem> items,
                       double tax, double discount) {
        super(storeName, storeAddress, dateTime, items, tax, discount);
    }

    @Override
    public String format() {
        StringBuilder sb = new StringBuilder();

        sb.append("<div class=\"receipt\">\n");
        sb.append("  <h1>").append(getStoreName()).append("</h1>\n");
        sb.append("  <p>").append(getStoreAddress()).append("</p>\n");
        sb.append("  <p>Дата: ").append(getDateTime()).append("</p>\n");
        sb.append("  <table>\n");
        sb.append("    <thead>\n");
        sb.append("      <tr><th>Товар</th><th>Кол-во</th><th>Цена</th><th>Сумма</th></tr>\n");
        sb.append("    </thead>\n");
        sb.append("    <tbody>\n");

        for (ReceiptItem item : getItems()) {
            double total = item.getPrice() * item.getQuantity();
            sb.append("      <tr>")
              .append("<td>").append(item.getName()).append("</td>")
              .append("<td>").append(item.getQuantity()).append("</td>")
              .append("<td>").append(String.format("%.2f", item.getPrice())).append("</td>")
              .append("<td>").append(String.format("%.2f", total)).append("</td>")
              .append("</tr>\n");
        }

        sb.append("    </tbody>\n");
        sb.append("  </table>\n");
        sb.append("  <p>Подытог: ").append(String.format("%.2f", calculateSubtotal())).append("</p>\n");
        sb.append("  <p>Налог: ").append(String.format("%.2f", calculateTaxAmount())).append("</p>\n");
        sb.append("  <p><strong>ИТОГО: ").append(String.format("%.2f", calculateTotal())).append("</strong></p>\n");
        sb.append("  <p>Спасибо за покупку!</p>\n");
        sb.append("</div>");

        return sb.toString();
    }
}