package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private List <Product> products ;
    private int size;
    private static final int basket = 5;

    public ProductBasket() {
        this.products = new ArrayList<>();
        this.size = 0;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public int getTotalPrice() {
        int total = 0;
        for (Product product : products) {
            total += product.getProductPrice();
        }
        return total;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }

        int specialCount = 0;
        for (Product product : products) {
            System.out.println(product.toString());
            if (product.isSpecial()) {
                specialCount++;
            }
        }

        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean containsProductByName(String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }
    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }

        return removedProducts;
    }

        public void clearBasket () {
            products.clear();
        }
    }


