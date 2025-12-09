package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Product juice = new Product("Сок", 250);
        Product chicken = new Product("Курица", 500);
        Product potato = new Product("Картошка", 150);
        Product eggs = new Product("Яйца", 110);
        Product lemonade = new Product("Лимонад", 90);
        Product tomato = new Product("Помидоры", 160);
        ProductBasket basket = new ProductBasket();
        basket.addProduct(juice);
        basket.addProduct(chicken);
        basket.addProduct(potato);
        basket.addProduct(eggs);
        basket.addProduct(lemonade);
        basket.addProduct(tomato);
        basket.printBasket();
        System.out.println("Если ли сок?" + basket.containsProductByName("сок "));
        System.out.println("Общая стоимоcть " + basket.getTotalPrice() + " рублей.");
        basket.clearBasket();
        basket.printBasket();
    }
}