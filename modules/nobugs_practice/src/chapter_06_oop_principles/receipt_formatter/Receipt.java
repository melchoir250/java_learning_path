package chapter_06_oop_principles.receipt_formatter;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Receipt {
    private final String storeName;
    private final String storeAddress;
    private final LocalDateTime dateTime;
    private final List<ReceiptItem> items;
    private final double tax;
    private final double discount;

    public Receipt(
            String storeName,
            String storeAddress,
            LocalDateTime dateTime,
            List<ReceiptItem> items,
            double tax,
            double discount
    ) {
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.dateTime = dateTime;
        this.items = items;
        this.tax = tax;
        this.discount = discount;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public List<ReceiptItem> getItems() {
        return items;
    }

    public double getTax() {
        return tax;
    }

    public double getDiscount() {
        return discount;
    }

    public double calculateSubtotal() {
        return items.stream().mapToDouble(items -> items.getPrice() * items.getQuantity()).sum();
    }

    public double calculateTaxAmount() {
        return calculateSubtotal() * tax;
    }

    public double calculateTotal() {
        return calculateSubtotal() + calculateTaxAmount();
    }

    public void addItem(ReceiptItem item) {
        items.add(item);
    }

    public void removeItem(ReceiptItem item) {
        items.remove(item);
    }

    public abstract String format();
}