package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Product juice = new DiscountedProduct("Сок", 250,70);
        Product chicken = new SimpleProduct("Курица", 500);
        Product potato = new DiscountedProduct("Картошка", 150, 20);
        Product eggs = new DiscountedProduct("Яйца", 110,10);
        Product lemonade = new FixPriceProduct("Лимонад");
        Product tomato = new FixPriceProduct("Помидоры");
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