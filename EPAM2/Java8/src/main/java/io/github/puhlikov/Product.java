package com.epam.training;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * create class Product
 */

public class Product {
    private String code;
    private String name;
    private double price;
    private List<String> categories;

    public Product(String code, String name, double price, List<String> categories){
        this.code = code;
        this.name = name;
        this.price = price;
        this.categories = categories;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                code.equals(product.code) &&
                name.equals(product.name) &&
                categories.equals(product.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, price, categories);
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", categories=" + categories +
                '}';
    }
}
