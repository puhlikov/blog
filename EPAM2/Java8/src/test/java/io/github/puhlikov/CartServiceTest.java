package com.epam.training;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Test class for CartServer
 */

public class CartServiceTest {

    private static CartService cartService;
    private static List<Product> products;
    private static List<Entry> entries = new ArrayList<>();

    /**
     * method initialization test context
     */

    @BeforeClass
    public static void initTest() {

        products = new ArrayList<>();
        products.add(new Product("qwer123", "shoes", 0.3, Arrays.asList("wear")));
        products.add(new Product("asdf321", "cream", 15, Arrays.asList("cosmetic")));

        cartService = new CartService();

        entries.add(new Entry(1, products.get(0), 1001));
        entries.add(new Entry(2, products.get(1), 8));
    }

    /**
     * Test, that collection not empty
     */

    @Test
    public void testInitEntries() {
        assertNotNull(cartService);
    }

    /**
     * Test for method getCollectionOfProductInCart
     */

    @Test
    public void testGetCollectionOfProductInCart() {
        assertEquals(cartService.getCollectionOfProductInCart(entries), products);
    }

    /**
     * Test for method getCartTotalPrice
     */

    @Test
    public void testGetCartTotalPrice() {
        assertEquals(cartService.getCartTotalPrice(entries), 420.3, 0.01);
    }

    /**
     * Test for method checkEntryTotal
     */

    @Test
    public void testCheckEntryTotal() {
        assertTrue(cartService.checkEntryTotal(entries));
    }

    /**
     * Test for method checkQuantity
     */

    @Test
    public void testCheckQuantity() {
        assertTrue(cartService.checkQuantity(entries));
    }

    /**
     * Test for method getEntryQuantity
     */

    @Test
    public void testGetEntryQuantity() {
        assertEquals(cartService.getEntryQuantity(entries), entries.get(0));
    }

    /**
     * Test for method getMaxProductPriceInCart
     */

    @Test
    public void testGetMaxProductPriceInCart() {
        assertEquals(cartService.getMaxProductPriceInCart(entries), 15,0.01);
    }

    /**
     * Test for method getMinProductPriceInCart
     */

    @Test
    public void testGetMinProductPriceInCart() {
        assertEquals(cartService.getMinProductPriceInCart(entries), 0.3,0.01);
    }

    /**
     * Test for method sortEntryByAscProductPrice
     */

    @Test
    public void testSortEntryByAscProductPrice() {
        List<Double> sortProductPrice = products.stream()
                .map(Product::getPrice)
                .sorted()
                .collect(Collectors.toList());
        assertEquals(cartService.sortEntryByAscProductPrice(entries), sortProductPrice);
    }

    /**
     * Test for method SortEntryByDescProductName
     */

    @Test
    public void testSortEntryByDescProductName() {
        List<String> sortProductName = products.stream()
                .map(Product::getName)
                .sorted((o1, o2) -> -o1.compareTo(o2))
                .collect(Collectors.toList());
        assertEquals(cartService.sortEntryByDescProductName(entries), sortProductName);
    }

    /**
     * Test for method getListAllProductNamesInCart
     */

    @Test
    public void testGetListAllProductNamesInCart() {
        List<String> names = products.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
        assertEquals(cartService.getListAllProductNamesInCart(entries), names);
    }

    /**
     * Test for method getAllEntriesWithProductCategoryCosmetic
     */

    @Test
    public void testGetAllEntriesWithProductCategoryCosmetic() {
        List<Entry> category = new ArrayList<>();
        category.add(new Entry(2, new Product("asdf321", "cream", 15, Arrays.asList("cosmetic")), 8));
        assertEquals(cartService.getAllEntriesWithProductCategoryCosmetic(entries), category);
    }

    /**
     * Test for method getUniqueCollectionAllCategoriesInCart
     */

    @Test
    public void testGetUniqueCollectionAllCategoriesInCart() {
        Set<String> category = new HashSet<>();
        category.add("wear");
        category.add("cosmetic");
        assertEquals(cartService.getUniqueCollectionAllCategoriesInCart(entries), category);
    }
}

