package mock_interviews.task10;

public class CartItem {
    private final String nameProduct;
    private double priceProduct;
    private int countProduct;

    public CartItem(String nameProduct, double priceProduct, int countProduct) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.countProduct = countProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public int getCountProduct() {
        return countProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public void setCountProduct(int countProduct) {
        this.countProduct = countProduct;
    }

    public double getTotalPrice() {
        return priceProduct * countProduct;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "name='" + getNameProduct() + '\'' +
                ", price=" + getPriceProduct() +
                ", count=" + getCountProduct() +
                '}';
    }
}