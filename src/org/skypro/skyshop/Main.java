package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Product cucumber = new SimpleProduct("огурец",200);
            System.out.println("Продукт добавлен:" + cucumber);
        } catch (IllegalAccessError e){
            System.out.println("Ошибка:" + e.getMessage());
        }
        try {
            Product cucumber = new SimpleProduct("Огурец",200);
            System.out.println("Продукт добавлен:" + cucumber);
        } catch (IllegalAccessError e){
            System.out.println("Ошибка:" + e.getMessage());
        }
        try {
            Product cucumber = new DiscountedProduct("Огурец",200, 10);
            System.out.println("Продукт добавлен:" + cucumber);
        } catch (IllegalAccessError e){
            System.out.println("Ошибка:" + e.getMessage());
        }
        try {
            Product cucumber = new DiscountedProduct("Огурец",100, 10);
            System.out.println("Продукт добавлен:" + cucumber);
        } catch (IllegalAccessError e){
            System.out.println("Ошибка:" + e.getMessage());
        }
        Product juice = new DiscountedProduct("Сок", 250, 70);
        Product chicken = new SimpleProduct("Курица", 500);
        Product potato = new DiscountedProduct("Картошка", 150, 20);
        Product eggs = new DiscountedProduct("Яйца", 110, 10);
        Product lemonade = new FixPriceProduct("Лимонад");
        Product tomato = new FixPriceProduct("Помидоры");
        ProductBasket basket = new ProductBasket();
        Article articleJuice = new Article("Магазинный сок: Польза или вред?", "В соке содержится много сахара, но также...");
        Article articleChicken = new Article("Курица как источник белка", "Не все части курицы имеют одинаковое КБЖУ...");
        Article articleTomato = new Article("Помидоры как источник клетчатки", "Помидоры действительно содержат в себе клетчатку, но...");
        basket.addProduct(juice);
        basket.addProduct(chicken);
        basket.addProduct(potato);
        basket.addProduct(eggs);
        basket.addProduct(lemonade);
        basket.addProduct(tomato);
        basket.printBasket();
        System.out.println("Удаление продукта из корзины");
        List<Product> removedProducts = basket.removeProductsByName("Сок");
        System.out.println("Удаленные продукты:");
        for (Product product : removedProducts) {
            System.out.println("  - " + product.getProductName() + ": " + product.getProductPrice() + " руб.");
        }
        System.out.println("Всего удалено: " + removedProducts.size() + " товар(ов)");
        System.out.println("Коризна после удаления продуктов");
        basket.printBasket();
        System.out.println("Если ли сок?" + basket.containsProductByName("сок"));
        System.out.println("Общая стоимоcть  " + basket.getTotalPrice() + " рублей.");
        basket.clearBasket();
        basket.printBasket();
        System.out.println("Поиск");
        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(juice);
        searchEngine.add(chicken);
        searchEngine.add(potato);
        searchEngine.add(eggs);
        searchEngine.add(lemonade);
        searchEngine.add(tomato);
        searchEngine.add(articleJuice);
        searchEngine.add(articleChicken);
        searchEngine.add(articleTomato);
        testSearch(searchEngine, "клетчатки");
        testSearch(searchEngine, "сахара");
        testSearch(searchEngine, "курица");
        testSearch(searchEngine, "польза");
        testSearch(searchEngine, "апельсин");


    }

    private static void testSearch(SearchEngine searchEngine, String query) {
        System.out.println("\nПоиск по запросу:  \"" + query + "\"");
        Searchable[] results = searchEngine.search(query).toArray(new Searchable[0]);

        boolean hasResults = false;
        for (Searchable result : results) {
            if (result != null) {
                System.out.println("- " + result.getStringRepresentation());
                hasResults = true;
            }
        }

        if (!hasResults) {
            System.out.println("Ничего не найдено");
        }
    }
}