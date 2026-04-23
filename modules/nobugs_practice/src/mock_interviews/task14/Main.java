package mock_interviews.task14;

public class Main {
    public static void main(String[] args) {
        Order successfulOrder = new Order("1001");
        System.out.println(successfulOrder.getCurrentStatus());
        successfulOrder.pay();
        System.out.println(successfulOrder.getCurrentStatus());
        successfulOrder.ship();
        System.out.println(successfulOrder.getCurrentStatus());
        successfulOrder.deliver();
        System.out.println(successfulOrder.getOrderID());
        System.out.println(successfulOrder.getCurrentStatus());

        successfulOrder.cancel();

        Order failedOrder = new Order("1002");
        failedOrder.ship(); // Ожидаем ошибку

        Order cancelledOrder = new Order("1003");
        cancelledOrder.pay();
        cancelledOrder.cancel();
    }
}