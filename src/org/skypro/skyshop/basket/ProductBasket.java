package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] products;
    private int size;
    private static final int basket = 5;

    public ProductBasket() {
        this.products = new Product[basket];
        this.size = 0;
    }

    public void addProduct(Product product) {
        if (size >= basket) {
            System.out.println("Добавление продукта в корзину невозможно.");
            return;
        }
        products[size] = product;
        size++;
    }

    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += products[i].getProductPrice();
        }
        return total;
    }

    public void printBasket() {
        if (size == 0) {
            System.out.println("в корзине пусто");
            return;
        }
        int specialCount = 0;

        for (int i = 0; i < size; i++) {
            Product product = products[i];
            System.out.println(product.getProductName() + ": " + product.getProductPrice());
            if (product.isSpecial()) {
                specialCount++;
            }
            System.out.println("Итого: " + getTotalPrice());
            System.out.println("Специальных товаров: " + specialCount);
        }
    }

        public boolean containsProductByName (String productName){
            for (int i = 0; i < size; i++) {
                if (products[i].getProductName().equals(productName)) {
                    return true;
                }
            }
            return false;
        }

        public void clearBasket () {
            for (int i = 0; i < size; i++) {
                products[i] = null;
            }
            size = 0;
        }
    }


