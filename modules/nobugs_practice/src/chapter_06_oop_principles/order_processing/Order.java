package chapter_06_oop_principles.order_processing;

public class Order {
    private int orderId;
    private String customerEmail;
    private double totalAmount;
    private boolean inventoryUpdated;
    private boolean confirmationSent;
    private int loyaltyPoints;

    public Order(
            int orderId,
            String customerEmail,
            double totalAmount
    ) {
        this.orderId = orderId;
        this.customerEmail = customerEmail;
        this.totalAmount = totalAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isInventoryUpdated() {
        return inventoryUpdated;
    }

    public void setInventoryUpdated(boolean inventoryUpdated) {
        this.inventoryUpdated = inventoryUpdated;
    }

    public boolean isConfirmationSent() {
        return confirmationSent;
    }

    public void setConfirmationSent(boolean confirmationSent) {
        this.confirmationSent = confirmationSent;
    }

    public int isLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
}