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
        productsMap.computeIfAbsent(productName, k -> new ArrayList<>());
    }

    public int getTotalPrice() {
        int total = 0;

        for (List<Product> productList : productsMap.values()) {
            for (Product product : productList) {
                total += product.getProductPrice();
            }
        }

        return total;
    }

    public void printBasket() {
        if (productsMap.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }

        int specialCount = 0;

        for (List<Product> productList : productsMap.values()) {
            for (Product product : productList) {
                System.out.println(product.toString());
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }

        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean containsProductByName(String productName) {
        return productsMap.containsKey(productName);
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = productsMap.remove(name);

        if (removedProducts == null) {
            return new ArrayList<>();
        }

        return removedProducts;
    }

    public void clearBasket() {
        productsMap.clear();
    }

    public int getSize() {
        int size = 0;
        for (List<Product> productList : productsMap.values()) {
            size += productList.size();
        }
        return size;
    }
}

