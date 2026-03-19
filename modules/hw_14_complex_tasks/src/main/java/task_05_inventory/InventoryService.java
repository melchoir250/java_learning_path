package task_05_inventory;

import java.util.*;
import java.util.stream.Collectors;

public class InventoryService {
    private final Map<String, List<Product>> inventory;
    private boolean isInventoryOpen;

    public InventoryService() {
        this.inventory = new HashMap<>();
        this.isInventoryOpen = true;
    }

    public void openInventory() {
        this.isInventoryOpen = true;
    }

    public void closeInventory() {
        this.isInventoryOpen = false;
    }

    public void addProduction(Product product) {
        if (!isInventoryOpen) {
            return;
        }
        String category = product.getCategory();
        inventory.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
    }

    public Product takeProduct(String category) throws OutOfStockException {
        if (!isInventoryOpen) {
            return null;
        }

        List<Product> products = inventory.get(category);

        if (products == null || products.isEmpty()) {
            throw new OutOfStockException(category);
        }

        return products.remove(0);
    }

    public List<Product> findProductsByCategory(String category) {
        List<Product> products = inventory.getOrDefault(category, Collections.emptyList());

        return products.stream().collect(Collectors.toList());
    }

    public List<Product> filterProductsPrice(double maxPrice) {
        return inventory.values().stream()
                .flatMap(Collection::stream)
                .filter(product -> product.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    public List<Product> filterProductsByCategoryAndPrice(String category, double maxPrice) {
        List<Product> products = inventory.getOrDefault(category, Collections.emptyList());
        return products.stream()
                .filter(product -> product.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }
}
