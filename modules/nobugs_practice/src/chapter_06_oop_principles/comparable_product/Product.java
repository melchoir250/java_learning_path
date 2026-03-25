package chapter_06_oop_principles.comparable_product;

public class Product implements Comparable<Product> {
    private final String nameProduct;
    private final double priceProduct;

    public Product(String nameProduct, double priceProduct) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
    }

    @Override
    public int compareTo(Product o) {
        int priceCompare = Double.compare(this.priceProduct, o.priceProduct);

        if (priceCompare != 0) {
            return priceCompare;
        }

        return this.nameProduct.compareTo(o.nameProduct);
    }

    @Override
    public String toString() {
        return nameProduct + " - " + priceProduct;
    }
}

