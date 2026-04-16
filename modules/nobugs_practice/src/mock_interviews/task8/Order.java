package mock_interviews.task8;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int numberOrder;
    private final List<Product> listProduct;

    public Order(int numberOrder) {
        this.numberOrder = numberOrder;
        this.listProduct = new ArrayList<>();
    }

    public int getNumberOrder() {
        return numberOrder;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void addProduct(Product product) {
        listProduct.add(product);
    }

    public double calculateTotal() {
        double sum = 0;
        for (Product item : listProduct) {
            sum += item.getItemTotalPrice();
        }
        return sum;
    }
}