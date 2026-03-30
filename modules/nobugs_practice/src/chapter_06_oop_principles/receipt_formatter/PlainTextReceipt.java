package chapter_06_oop_principles.receipt_formatter;

import java.time.LocalDateTime;
import java.util.List;

public class PlainTextReceipt extends Receipt {

    public PlainTextReceipt(String storeName, String storeAddress,
                            LocalDateTime dateTime, List<ReceiptItem> items,
                            double tax, double discount) {
        super(storeName, storeAddress, dateTime, items, tax, discount);
    }

    @Override
    public String format() {
        StringBuilder sb = new StringBuilder();

        sb.append("======================\n");
        sb.append("   ").append(getStoreName()).append("\n");
        sb.append("   ").append(getStoreAddress()).append("\n");
        sb.append("======================\n");
        sb.append("Дата: ").append(getDateTime()).append("\n\n");

        sb.append("-------------------------------------\n");
        sb.append(String.format("%-15s %-8s %-8s %-8s\n", "Товар", "Кол-во", "Цена", "Сумма"));
        sb.append("-------------------------------------\n");

        for (ReceiptItem item : getItems()) {
            double total = item.getPrice() * item.getQuantity();
            sb.append(String.format(
                    "%-15s %-8d %-8.2f %-8.2f\n",
                    item.getName(),
                    item.getQuantity(),
                    item.getPrice(),
                    total
            ));
        }

        sb.append("-------------------------------------\n");

        double subtotal = calculateSubtotal();
        double taxAmount = calculateTaxAmount();
        double total = calculateTotal();

        sb.append(String.format("%-25s %.2f\n", "Подытог:", subtotal));
        sb.append(String.format("%-25s %.2f\n", "Налог:", taxAmount));
        sb.append("-------------------------------------\n");
        sb.append(String.format("%-25s %.2f\n", "ИТОГО:", total));

        sb.append("======================\n");
        sb.append("Спасибо за покупку!\n");

        return sb.toString();
    }
}
