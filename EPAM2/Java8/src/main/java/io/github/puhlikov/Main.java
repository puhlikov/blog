package com.epam.training;

import com.epam.training.Entry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Entry> entries = new ArrayList<>();

        entries.add(new Entry(1, new Product("qwer123", "shoes", 0.3, Arrays.asList("wear")), 1001));
        entries.add(new Entry(2, new Product("asdf321", "beef", 15, Arrays.asList("meat")), 8));
        entries.add(new Entry(3, new Product("zxcv231", "juice", 3, Arrays.asList("drink")), 1));
        entries.add(new Entry(4, new Product("tyui321", "sausage", 5, Arrays.asList("meat")), 3));
        entries.add(new Entry(5, new Product("ghjk231", "dress", 800, Arrays.asList("wear")), 1));
        entries.add(new Entry(6, new Product("bnm123", "cream", 8, Arrays.asList("cosmetic")), 2));
        entries.add(new Entry(7, new Product("poiu321", "cologne", 7, Arrays.asList("cosmetic")), 1));
        entries.add(new Entry(8, new Product("jhgf231", "notepad", 2, Arrays.asList("stationery")), 2));
        entries.add(new Entry(9, new Product("werd123", "pencil", 1, Arrays.asList("stationery")), 11));
        entries.add(new Entry(10, new Product("mnbv32", "bread", 1, Arrays.asList("bakery product")), 1));


        CartService cartService = new CartService();

        System.out.println("1. Get a collection of products in cart: " + cartService.getCollectionOfProductInCart(entries));

        System.out.println("2. Get cart total price: " + cartService.getCartTotalPrice(entries));

        System.out.println("3. Сheck that no entry total does not exceed 1000 : " + cartService.checkEntryTotal(entries));

        System.out.println("4. Is the quantity of products > 10?: " + cartService.checkQuantity(entries));

        System.out.println("5. Get quantity of products > 3 : " + cartService.getEntryQuantity(entries));

        System.out.println("6. Get max product price in cart : " + cartService.getMaxProductPriceInCart(entries) + " and " + "Get min product price in cart : " + cartService.getMinProductPriceInCart(entries));

        System.out.println("7. Sort entry by asc product price: " + cartService.sortEntryByAscProductPrice(entries));

        System.out.println("8. Sort entry by desc product name: " + cartService.sortEntryByDescProductName(entries));

        System.out.println("9. Get list all product names in cart: " + cartService.getListAllProductNamesInCart(entries));

        System.out.println("10. Get all entries with product category “Cosmetic”: " + cartService.getAllEntriesWithProductCategoryCosmetic(entries));

        System.out.println("11. Get unique collection of all categories in cart: " + cartService.getUniqueCollectionAllCategoriesInCart(entries));
    }
}
