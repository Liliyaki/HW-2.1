package org.skypro.skyshop.product;
import org.skypro.skyshop.search.Searchable;
public class DiscountedProduct extends Product {
    private final int basedPrice;
    private final int discount;

    public DiscountedProduct(String productName, int basedPrice, int discount) {
        super(productName);
        this.basedPrice = basedPrice;
        this.discount = discount;
    }

    @Override
    public int getProductPrice() {
        return basedPrice - (basedPrice * discount / 100);
    }
    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return productName + " со скидкой" + ": " + basedPrice + " рублей со скидкой " + discount + "%";
    }
}

