package task_02_kiss;

public class DiscountCalculator {
    public double calculateDiscount(
            double price,
            boolean isLoyalCustomer,
            boolean isFirstPurchase,
            boolean hasCoupon
    ) {
        if (isLoyalCustomer && isFirstPurchase) {
            return price * 0.90;
        }
        if (isLoyalCustomer) {
            return price * 0.95;
        }
        if (hasCoupon) {
            return price * 0.93;
        }
        return price * 0.98;
    }
}