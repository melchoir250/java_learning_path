package chapter_06_oop_principles.receipt_formatter;

import java.time.LocalDateTime;
import java.util.List;

public class JsonReceipt extends Receipt {

    public JsonReceipt(String storeName, String storeAddress, LocalDateTime dateTime, List<ReceiptItem> items,
                       double tax, double discount) {
        super(storeName, storeAddress, dateTime, items, tax, discount);
    }

    @Override
    public String format() {
        StringBuilder sb = new StringBuilder();

        sb.append("{\n");
        sb.append("  \"storeName\": \"").append(getStoreName()).append("\",\n");
        sb.append("  \"storeAddress\": \"").append(getStoreAddress()).append("\",\n");
        sb.append("  \"date\": \"").append(getDateTime()).append("\",\n");
        sb.append("  \"items\": [\n");

        List<ReceiptItem> items = getItems();
        for (int i = 0; i < items.size(); i++) {
            ReceiptItem item = items.get(i);
            sb.append("    {\n");
            sb.append("      \"name\": \"").append(item.getName()).append("\",\n");
            sb.append("      \"quantity\": ").append(item.getQuantity()).append(",\n");
            sb.append("      \"unitPrice\": ").append(String.format("%.2f", item.getPrice())).append(",\n");
            sb.append("      \"total\": ").append(String.format("%.2f", item.getPrice() * item.getQuantity())).append("\n");
            sb.append("    }");
            if (i < items.size() - 1) {
                sb.append(",");
            }
            sb.append("\n");
        }

        sb.append("  ],\n");
        sb.append("  \"subtotal\": ").append(String.format("%.2f", calculateSubtotal())).append(",\n");
        sb.append("  \"tax\": ").append(String.format("%.2f", calculateTaxAmount())).append(",\n");
        sb.append("  \"total\": ").append(String.format("%.2f", calculateTotal())).append(",\n");
        sb.append("  \"message\": \"Спасибо за покупку!\"\n");
        sb.append("}");

        return sb.toString();
    }
}