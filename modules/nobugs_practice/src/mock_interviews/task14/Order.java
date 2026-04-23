package mock_interviews.task14;

public class Order {
    private final String orderID;
    private OrderStatus currentStatus;

    public Order(String orderID) {
        this.orderID = orderID;
        this.currentStatus = OrderStatus.CREATED;
    }

    public String getOrderID() {
        return orderID;
    }

    public OrderStatus getCurrentStatus() {
        return currentStatus;
    }

    public void pay() {
        if (this.currentStatus == OrderStatus.CREATED) {
            this.currentStatus = OrderStatus.PAID;
        } else {
            System.out.println("Ошибка: заказ уже оплачен, отменен или доставлен");
        }
    }

    public void ship() {
        if (this.currentStatus == OrderStatus.PAID) {
            this.currentStatus = OrderStatus.SHIPPED;
        } else if (this.currentStatus == OrderStatus.CREATED) {
            System.out.println("Ошибка: заказ должен быть оплачен");
        } else {
            System.out.println("Ошибка: нельзя отправить заказ из состояния " + this.currentStatus);
        }
    }

    public void deliver() {
        if (this.currentStatus == OrderStatus.SHIPPED) {
            this.currentStatus = OrderStatus.DELIVERED;
        } else {
            System.out.println("Ошибка: заказ должен быть отправлен перед доставкой");
        }
    }

    public void cancel() {
        if (this.currentStatus == OrderStatus.CREATED || this.currentStatus == OrderStatus.PAID) {
            this.currentStatus = OrderStatus.CANCELLED;
        } else {
            System.out.println("Ошибка: нельзя отменить заказ, который уже отправлен или доставлен");
        }
    }
}