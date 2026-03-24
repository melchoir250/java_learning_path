package chapter_06_oop_principles.shopping_cart;

public class Product {
    private final String nameProduct;
    private final double priceProduct;

    public Product(String nameProduct, double priceProduct) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }
}