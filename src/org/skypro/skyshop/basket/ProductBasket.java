package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> productsMap;

    public ProductBasket() {
        this.productsMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        String productName = product.getProductName();
        productsMap.computeIfAbsent(productName, k -> new ArrayList<>()).add(product);
    }

    public int getTotalPrice() {
        return productsMap.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getProductPrice)
                .sum();
    }

    private long getSpecialCount() {
        return productsMap.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public void printBasket() {
        if (productsMap.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }

        productsMap.values().stream()
                .flatMap(Collection::stream)
                .forEach(product -> System.out.println(product.toString()));

        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    public boolean containsProductByName(String productName) {
        return productsMap.containsKey(productName);
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = productsMap.remove(name);
        return removedProducts == null ? new ArrayList<>() : removedProducts;
    }

    public void clearBasket() {
        productsMap.clear();
    }

    public int getSize() {
        return productsMap.values().stream()
                .mapToInt(List::size)
                .sum();
    }
}

