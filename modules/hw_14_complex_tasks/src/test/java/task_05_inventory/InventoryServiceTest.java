package task_05_inventory;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryServiceTest {

    private InventoryService inventoryService;
    private Product phone1;
    private Product phone2;
    private Product laptop;
    private Product mouse;

    @BeforeEach
    public void setUp() {
        inventoryService = new InventoryService();

        phone1 = new Product("Iphone 17 pro", 990, "Phone");
        phone2 = new Product("Iphone 17 pro Max", 1090, "Phone");
        laptop = new Product("Macbook Pro m5max", 2190, "Laptop");
        mouse = new Product("Logitech g450", 90, "Mouse");
    }

    @Test
    public void shouldAddProductWhenInventoryAdd() {
        inventoryService.addProduction(phone1);

        List<Product> phones = inventoryService.findProductsByCategory("Phone");
        assertEquals(1, phones.size());
        assertTrue(phones.contains(phone1));
    }

    @Test
    public void shouldAddProductWhenInventoryClose() {
        inventoryService.closeInventory();

        inventoryService.addProduction(phone1);

        List<Product> phones = inventoryService.findProductsByCategory("Phone");
        assertTrue(phones.isEmpty());
    }

    @Test
    public void shouldTakeProductSuccessfully() throws OutOfStockException {
        inventoryService.addProduction(laptop);
        Product takeLaptop = inventoryService.takeProduct("Laptop");
        assertEquals(laptop, takeLaptop);

        List<Product> laptop = inventoryService.findProductsByCategory("Laptop");
        assertTrue(laptop.isEmpty());
    }

    ;

    @Test
    public void shouldTakeProductThrowException() {
        OutOfStockException outOfStockException = assertThrows(
                OutOfStockException.class, () -> inventoryService.takeProduct("Phone")
        );

        assertEquals("Ошибка! В данной категории Phone закончились товары",
                outOfStockException.getMessage());
    }

    @Test
    public void shouldFilterPriceByProductAllCategories() {
        inventoryService.addProduction(phone1);
        inventoryService.addProduction(phone2);
        inventoryService.addProduction(laptop);
        inventoryService.addProduction(mouse);

        List<Product> products = inventoryService.filterProductsPrice(1000);
        assertEquals(2, products.size());
        assertTrue(products.contains(phone1));
        assertTrue(products.contains(mouse));
        assertFalse(products.contains(phone2));
    }

    @Test
    public void shouldFilterPriceByProductAllCategoriesPhone() {
        inventoryService.addProduction(phone1);
        inventoryService.addProduction(phone2);
        inventoryService.addProduction(laptop);
        inventoryService.addProduction(mouse);

        List<Product> products = inventoryService.filterProductsByCategoryAndPrice("Phone", 1000);

        assertEquals(1, products.size());
        assertTrue(products.contains(phone1));
        assertFalse(products.contains(phone2));
    }
}