package com.epam.training;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * create class CartService
 */

public class CartService {


    /**
     * create method getCollectionOfProductInCart. Get collection products in cart.
     */

    public List<Product> getCollectionOfProductInCart(List<Entry> entries) {
        return entries.stream()
                .map(entry -> entry.getProduct())
                .collect(Collectors.toList());
    }

    /**
     * create method getCartTotalPrice. Get total price all products in cart.
     */

    public double getCartTotalPrice(List<Entry> entries) {
        return entries.stream()
                .mapToDouble(entry -> (entry.getProduct().getPrice() * entry.getQuantity()))
                .sum();
    }

    /**
     * create method checkEntryTotal. Сheck, that no entry total does not exceed 1000.
     */

    public boolean checkEntryTotal(List<Entry> entries) {
        return entries.stream()
                .allMatch(entry -> (entry.getProduct().getPrice() * entry.getQuantity()) < 1000);
    }

    /**
     * create method checkQuantity. Сheck, that at least 1 entry quantity > 10.
     */

    public boolean checkQuantity(List<Entry> entries) {
        return (boolean) entries.stream()
              .anyMatch(entry -> entry.getQuantity() > 10);
    }

    /**
     * create method getEntryQuantity. Get entry with quantity > 3.
     */

    public Entry getEntryQuantity(List<Entry> entries) {
        return (entries.stream()
                .filter(entry -> entry.getQuantity() > 3)
                .findFirst()
                .get());
    }

    /**
     * create method getMaxProductPriceInCart. Get max product price in cart.
     */

    public double getMaxProductPriceInCart(List<Entry> entries) {
        return entries.stream()
                .map(entry -> entry.getProduct().getPrice())
                .max(Double::compareTo).get();
    }

    /**
     * create method getMinProductPriceInCart. Get min product price in cart.
     */

    public double getMinProductPriceInCart(List<Entry> entries) {
        return (entries.stream()
                .map(entry -> entry.getProduct().getPrice())
                .min(Double::compareTo).get());
    }

    /**
     * create method sortEntryByAscProductPrice. Sort entry by asc product price.
     */

    public List<Double> sortEntryByAscProductPrice(List<Entry> entries) {
        return entries.stream()
                .map(entry -> entry.getProduct().getPrice())
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * create method sortEntryByDescProductName. Sort entry by desc product name.
     */

    public List<String> sortEntryByDescProductName(List<Entry> entries) {
        return entries.stream()
                .map(entry -> entry.getProduct().getName())
                .sorted((o1, o2) -> -o1.compareTo(o2))
                .collect(Collectors.toList());
    }

    /**
     * create method getListAllProductNamesInCart. Get list all product names in cart.
     */

    public List<String> getListAllProductNamesInCart(List<Entry> entries) {
        return entries.stream()
                .map(entry -> entry.getProduct().getName())
                .collect(Collectors.toList());
    }

    /**
     * create method getAllEntriesWithProductCategoryCosmetic. Get all entries with product category “Cosmetic”.
     */

    public List<Entry> getAllEntriesWithProductCategoryCosmetic(List<Entry> entries) {
        return entries.stream()
                .filter(entry -> (entry.getProduct().getCategories().contains("cosmetic"))).collect(Collectors.toList());
    }

    /**
     * create method getUniqueCollectionAllCategoriesInCart. Get unique collection of all categories in cart.
     */

    public Set<String> getUniqueCollectionAllCategoriesInCart(List<Entry> entries) {
        return entries.stream()
                .map(entry -> entry.getProduct()
                        .getCategories().iterator().next())
                .collect(Collectors.toSet());
    }
}
