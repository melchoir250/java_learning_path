package mock_interviews.task8;

public class Product {
    protected String nameProduct;
    protected double priceProduct;
    protected int countProduct;

    public Product(String nameProduct, double priceProduct, int countProduct) {
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

    public double getItemTotalPrice() {
        return getPriceProduct() * getCountProduct();
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public void setCountProduct(int countProduct) {
        this.countProduct = countProduct;
    }
}