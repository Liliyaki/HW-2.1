package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    public final int price;

    public SimpleProduct(String productName, int price) {
        super(productName);
        this.price = price;
    }

    @Override
    public int getProductPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return productName + ": " + price + " рублей.";
    }
}

